import React, { useState } from 'react'
import api from '../services/api'
import { saveAuth } from '../services/authService'
import { useNavigate, Link } from 'react-router-dom'
import Input from '../components/Input'
import Button from '../components/Button'
import Alert from '../components/Alert'

export default function Login(){
  const [email,setEmail] = useState('')
  const [senha,setSenha] = useState('')
  const [error,setError] = useState(null)
  const navigate = useNavigate()

  async function handleSubmit(e){
    e.preventDefault()
    setError(null)
    try{
      // Requisição ao backend: POST /api/login
      // Backend atual retorna { usuarioId, usuarioNome } (não retorna JWT)
      const res = await api.post('/login', { email, senha })
      // extrai dados retornados
      const data = res.data
      if(data && data.usuarioId){
        // Salva informações de autenticação localmente (token simulado)
        saveAuth({ usuarioId: data.usuarioId, usuarioNome: data.usuarioNome })
        navigate('/receitas')
      } else {
        setError(data.message || 'Resposta inesperada')
      }
    }catch(err){
      setError(err.response?.data?.message || err.message || 'Erro ao autenticar')
    }
  }

  return (
    <div className="max-w-md mx-auto mt-8 card">
      <h2 className="text-2xl font-semibold mb-3">Login</h2>
      {error && <Alert>{error}</Alert>}
      <form onSubmit={handleSubmit}>
        <div className="space-y-3">
          <Input label="Email" type="email" value={email} onChange={e => setEmail(e.target.value)} />
          <Input label="Senha" type="password" value={senha} onChange={e => setSenha(e.target.value)} />
        </div>
        <div className="flex gap-3 mt-4">
          <Button type="submit">Entrar</Button>
          <Link to="/register"><Button className="secondary">Registrar</Button></Link>
        </div>
      </form>
    </div>
  )
}
