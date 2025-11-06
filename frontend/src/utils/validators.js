export function required(v){
  return v != null && String(v).trim() !== ''
}

export function isEmail(v){
  return /.+@.+\..+/.test(v)
}
