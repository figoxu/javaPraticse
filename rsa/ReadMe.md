* openssl genrsa -out rsa_private_key.pem 1024 -x509
* openssl rsa -in rsa_private_key.pem -pubout -out rsa_public_key.pem
* openssl pkcs8 -topk8 -inform PEM -outform PEM -in rsa_private_key.pem -out rsa_private_key_pkcs8.pem -nocrypt