import React from 'react'

export default function Alert({ type = 'error', children }) {
  return (
    <div className={`alert ${type === 'error' ? 'error' : 'success'}`}>
      {children}
    </div>
  )
}
