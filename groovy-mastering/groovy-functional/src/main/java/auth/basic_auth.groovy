package auth

// trival username, password
String u = 'username'
String p = 'password'

// base 64 encoding
String encoded = "$u:$p".bytes.encodeBase64()
println "$u:$p -> $encoded"

def (user, pass) = new String(encoded.decodeBase64()).split(':')
println "(user, pass) = ($user, $pass)"

assert user == u
assert pass == p