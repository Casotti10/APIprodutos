import React from 'react'

export default function Input({ label, ...props }) {
  return (
    <label className="block">
      {label && <div className="text-sm text-gray-700 mb-1">{label}</div>}
      <input className="input" {...props} />
    </label>
  )
}
