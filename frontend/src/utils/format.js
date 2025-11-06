import dayjs from 'dayjs'

export function formatCurrency(v){
  if (v == null) return ''
  return new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(v)
}

export function formatDate(d){
  if(!d) return ''
  return dayjs(d).format('YYYY-MM-DD')
}
