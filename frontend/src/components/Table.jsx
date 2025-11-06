import React from 'react'

export default function Table({ columns = [], data = [], actions = (row) => null }) {
  return (
    <div className="overflow-x-auto">
      <table className="table">
        <thead>
          <tr className="bg-gray-50">
            {columns.map((c) => <th key={c.key} className="text-sm text-gray-600">{c.title}</th>)}
            <th className="text-sm text-gray-600">Ações</th>
          </tr>
        </thead>
        <tbody>
          {data.length === 0 ? (
            <tr><td colSpan={columns.length + 1} className="p-3">Nenhum registro</td></tr>
          ) : (
            data.map((row) => (
              <tr key={row.id} className="hover:bg-gray-50">
                {columns.map(c => <td key={c.key}>{c.render ? c.render(row) : row[c.key]}</td>)}
                <td>{actions(row)}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  )
}
