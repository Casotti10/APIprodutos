import React, { useState } from 'react'
import api from '../services/api'
import { useNavigate } from 'react-router-dom'
import Input from '../components/Input'
import Button from '../components/Button'
import Alert from '../components/Alert'
import { required, isEmail } from '../utils/validators'

export default function Register(){
  const [nome,setNome] = useState('')
  const [email,setEmail] = useState('')
  const [senha,setSenha] = useState('')
  const [error,setError] = useState(null)
  const [success,setSuccess] = useState(null)
  const navigate = useNavigate()

  async function handleSubmit(e){
    e.preventDefault()
    setError(null)
    setSuccess(null)
    if(!required(nome) || !required(email) || !required(senha)){
      setError('Preencha todos os campos')
      return
    }
    if(!isEmail(email)){
      setError('Email inválido')
      return
    }
  try{
  // POST /api/usuarios (plural) - criar usuário
  await api.post('/usuarios', { nome, email, senha })
      setSuccess('Usuário criado com sucesso. Faça login.')
      setTimeout(()=>navigate('/login'),1200)
    }catch(err){
      setError(err.response?.data?.message || err.message || 'Erro ao registrar')
    }
  }

  return (
    <div className="max-w-lg mx-auto mt-8 card">
      <h2 className="text-2xl font-semibold mb-3">Registrar</h2>
      {error && <Alert>{error}</Alert>}
      {success && <Alert type="success">{success}</Alert>}
      <form onSubmit={handleSubmit}>
        <div className="space-y-3">
          <Input label="Nome" value={nome} onChange={e => setNome(e.target.value)} />
          <Input label="Email" type="email" value={email} onChange={e => setEmail(e.target.value)} />
          <Input label="Senha" type="password" value={senha} onChange={e => setSenha(e.target.value)} />
        </div>
        <div className="flex gap-3 mt-4">
          <Button type="submit">Criar conta</Button>
        </div>
      </form>
    </div>
  )
}
