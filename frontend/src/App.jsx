import React from 'react'
import { Routes, Route, Navigate } from 'react-router-dom'
import Login from './pages/Login'
import Register from './pages/Register'
import Receitas from './pages/Receitas'
import Despesas from './pages/Despesas'
import Relatorios from './pages/Relatorios'
import NotFound from './pages/NotFound'
import Navbar from './components/Navbar'
import { isAuthenticated } from './services/authService'

// Simple protected-route wrapper using a component that redirects when not authenticated
function PrivateRoute({ children }) {
  return isAuthenticated() ? children : <Navigate to="/login" replace />
}

export default function App() {
  return (
    <div className="app-root">
      <Navbar />
      <main className="container">
        <Routes>
          <Route path="/" element={<Navigate to="/receitas" replace />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />

          <Route path="/receitas" element={<PrivateRoute><Receitas /></PrivateRoute>} />
          <Route path="/despesas" element={<PrivateRoute><Despesas /></PrivateRoute>} />
          <Route path="/relatorios" element={<PrivateRoute><Relatorios /></PrivateRoute>} />

          <Route path="*" element={<NotFound />} />
        </Routes>
      </main>
    </div>
  )
}
