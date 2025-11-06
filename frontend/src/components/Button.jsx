import React from 'react'

export default function Button({ children, type = 'button', className = '', ...props }) {
  // Keep compatibility with usages that pass className="secondary"
  const isSecondary = className && className.includes('secondary')
  const classes = `btn ${isSecondary ? 'secondary' : 'primary'} ${className}`.trim()
  return (
    <button type={type} className={classes} {...props}>
      {children}
    </button>
  )
}
