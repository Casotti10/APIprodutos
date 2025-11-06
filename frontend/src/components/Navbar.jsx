import React from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { getUsuarioNome, isAuthenticated, logout } from '../services/authService'

export default function Navbar() {
  const navigate = useNavigate()
  const nome = getUsuarioNome()

  function handleLogout() {
    logout()
    navigate('/login')
  }

  return (
    <nav className="navbar">
      <div className="flex items-center gap-3">
        <strong className="text-lg">Controle Financeiro</strong>
      </div>
      <div className="nav-links">
        {isAuthenticated() ? (
          <>
            <Link className="text-gray-700 hover:text-blue-600" to="/receitas">Receitas</Link>
            <Link className="text-gray-700 hover:text-blue-600" to="/despesas">Despesas</Link>
            <Link className="text-gray-700 hover:text-blue-600" to="/relatorios">Relatórios</Link>
            <span className="text-sm text-gray-500">Olá, {nome}</span>
            <button className="btn secondary" onClick={handleLogout}>Logout</button>
          </>
        ) : (
          <>
            <Link className="text-gray-700 hover:text-blue-600" to="/login">Login</Link>
            <Link className="text-gray-700 hover:text-blue-600" to="/register">Registrar</Link>
          </>
        )}
      </div>
    </nav>
  )
}
