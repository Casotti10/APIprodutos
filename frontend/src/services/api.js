import axios from 'axios'
import { getAuthToken, logout } from './authService'

// Base axios instance
// Use Vite environment variable VITE_API_BASE to allow pointing to a remote backend (ex: "https://plutal.example.com/api")
// Falls back to local backend at http://localhost:8080/api
const baseURL = import.meta.env.VITE_API_BASE || 'http://localhost:8080/api'

const api = axios.create({
  baseURL,
  headers: {
    'Content-Type': 'application/json'
  }
})

// Request interceptor to inject token (simulado se necessário)
api.interceptors.request.use(
  (config) => {
    const token = getAuthToken()
    if (token) {
      config.headers = config.headers || {}
      config.headers['Authorization'] = `Bearer ${token}`
    }
    return config
  },
  (error) => Promise.reject(error)
)

// Response interceptor: simples tratamento de erros globais
api.interceptors.response.use(
  (res) => res,
  (error) => {
    // Se 401, deslogar automaticamente
    if (error.response && error.response.status === 401) {
      logout()
      // opcional: redirecionamento feito no frontend
    }
    return Promise.reject(error)
  }
)

export default api
