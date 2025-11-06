// Pequeno serviço de autenticação que trabalha com o backend atual
// Observação: o backend atual NÃO retorna JWT. Aqui armazenamos um objeto 'auth' no localStorage
// e geramos um token simulado (base64 do id do usuário). Se o backend passar a retornar JWT,
// basta salvar esse token e ajustar getAuthToken.

export function saveAuth({ usuarioId, usuarioNome }){
  const token = btoa(String(usuarioId)) // token simulado
  const auth = { usuarioId, usuarioNome, token }
  localStorage.setItem('auth', JSON.stringify(auth))
  return auth
}

export function getAuth(){
  const raw = localStorage.getItem('auth')
  if(!raw) return null
  try{
    return JSON.parse(raw)
  }catch(e){
    return null
  }
}

export function getAuthToken(){
  const a = getAuth()
  return a ? a.token : null
}

export function getUsuarioId(){
  const a = getAuth()
  return a ? a.usuarioId : null
}

export function getUsuarioNome(){
  const a = getAuth()
  return a ? a.usuarioNome : null
}

export function isAuthenticated(){
  return !!getAuth()
}

export function logout(){
  localStorage.removeItem('auth')
  window.location.href = '/login'
}
