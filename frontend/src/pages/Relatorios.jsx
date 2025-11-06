import React, { useState } from 'react'
import api from '../services/api'
import { getUsuarioId } from '../services/authService'
import Input from '../components/Input'
import Button from '../components/Button'
import Alert from '../components/Alert'
import { formatCurrency } from '../utils/format'

export default function Relatorios(){
  const [ano,setAno] = useState(new Date().getFullYear())
  const [mes,setMes] = useState(new Date().getMonth() + 1)
  const [data,setData] = useState(null)
  const [error,setError] = useState(null)

  async function buscar(){
    setError(null)
    try{
      const usuarioId = getUsuarioId()
      const res = await api.get(`/relatorio/saldo/${usuarioId}`, { params: { ano, mes } })
      setData(res.data)
    }catch(err){
      setError(err.response?.data?.message || err.message)
    }
  }

  return (
    <div>
      <h2 className="text-2xl font-semibold mb-3">Relatórios</h2>
      <div className="card">
        {error && <Alert>{error}</Alert>}
        <div className="form-row items-end">
          <Input label="Ano" type="number" value={ano} onChange={e => setAno(e.target.value)} />
          <Input label="Mês" type="number" value={mes} onChange={e => setMes(e.target.value)} />
          <div>
            <Button onClick={buscar}>Buscar</Button>
          </div>
        </div>

        {data && (
          <div className="mt-4">
            <h4 className="font-medium mb-4">Saldo - {mes}/{ano}</h4>

            <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
              <div className="card">
                <div className="text-sm text-gray-500">Total Receita</div>
                <div className="text-2xl font-semibold mt-2">{formatCurrency(data.totalReceita ?? 0)}</div>
              </div>

              <div className="card">
                <div className="text-sm text-gray-500">Total Despesa</div>
                <div className="text-2xl font-semibold mt-2">{formatCurrency(data.totalDespesa ?? 0)}</div>
              </div>

              <div className="card">
                <div className="text-sm text-gray-500">Saldo Mensal</div>
                <div className={`text-2xl font-semibold mt-2 ${((data.saldoMensal ?? 0) < 0) ? 'text-red-600' : 'text-green-600'}`}>
                  {formatCurrency(data.saldoMensal ?? 0)}
                </div>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  )
}
