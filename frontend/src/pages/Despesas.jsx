import React, { useEffect, useState } from 'react'
import api from '../services/api'
import { getUsuarioId } from '../services/authService'
import Table from '../components/Table'
import Button from '../components/Button'
import Alert from '../components/Alert'
import Input from '../components/Input'
import { formatCurrency, formatDate } from '../utils/format'

export default function Despesas(){
  const [data,setData] = useState([])
  const [loading,setLoading] = useState(false)
  const [error,setError] = useState(null)
  const [editing,setEditing] = useState(null)
  const [descricao,setDescricao] = useState('')
  const [valor,setValor] = useState('')
  const [dataField,setDataField] = useState('')

  async function load(){
    setLoading(true); setError(null)
    try{
  // GET /api/despesas - lista todas as despesas (backend usa /despesas)
  const res = await api.get('/despesas')
      setData(res.data || [])
    }catch(err){
      setError(err.response?.data?.message || err.message)
    }finally{setLoading(false)}
  }

  useEffect(()=>{load()},[])

  function startEdit(row){
    setEditing(row)
    setDescricao(row.descricao)
    setValor(String(row.valor))
    const dateVal = row.dataDespesa || row.data || row.data_despesa
    setDataField(formatDate(dateVal))
  }

  function resetForm(){
    setEditing(null); setDescricao(''); setValor(''); setDataField('')
  }

  async function handleSave(e){
    e && e.preventDefault()
    setError(null)
    try{
      if(editing){
        const payload = { descricao, valor: parseFloat(valor), dataDespesa: dataField, usuario: { id: getUsuarioId() } }
        await api.put(`/despesas/${editing.id}`, payload)
      } else {
  // POST /api/despesas - criar nova despesa (backend espera dataDespesa and usuario)
  const body = { descricao, valor: parseFloat(valor), dataDespesa: dataField, usuario: { id: getUsuarioId() } }
  await api.post('/despesas', body)
      }
      resetForm(); load()
    }catch(err){
      setError(err.response?.data?.message || err.message)
    }
  }

  async function handleDelete(id){
    if(!confirm('Confirmar exclusão?')) return
    try{
      await api.delete(`/despesas/${id}`)
      load()
    }catch(err){
      alert(err.response?.data?.message || err.message)
    }
  }

  const columns = [
    { key: 'descricao', title: 'Descrição' },
    { key: 'valor', title: 'Valor', render: (r)=>formatCurrency(r.valor) },
    { key: 'data', title: 'Data', render: (r)=>formatDate(r.dataDespesa || r.data || r.data_despesa) }
  ]

  return (
    <div>
      <h2 className="text-2xl font-semibold mb-3">Despesas</h2>
      <div className="card">
        <h3 className="text-lg font-medium mb-2">{editing ? 'Editar Despesa' : 'Nova Despesa'}</h3>
        {error && <Alert>{error}</Alert>}
        <form onSubmit={handleSave}>
          <div className="form-row">
            <Input label="Descrição" value={descricao} onChange={e => setDescricao(e.target.value)} />
            <Input label="Valor" value={valor} onChange={e => setValor(e.target.value)} />
            <Input label="Data" type="date" value={dataField} onChange={e => setDataField(e.target.value)} />
          </div>
          <div className="flex gap-3 mt-3">
            <Button type="submit">Salvar</Button>
            <Button type="button" className="secondary" onClick={resetForm}>Cancelar</Button>
          </div>
        </form>
      </div>

      <div className="card mt-6">
        <h3 className="text-lg font-medium mb-2">Lista de Despesas</h3>
        {loading ? <div>Carregando...</div> : (
          <Table columns={columns} data={data} actions={(row) => (
            <>
              <button className="btn secondary" onClick={() => startEdit(row)}>Editar</button>
              <button className="btn" style={{ background: '#ef4444', marginLeft: 8 }} onClick={() => handleDelete(row.id)}>Deletar</button>
            </>
          )} />
        )}
      </div>
    </div>
  )
}
