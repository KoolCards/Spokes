from flask import Flask
import firebase_admin
from firebase_admin import credentials
from firebase_admin import auth
from flask import request

app = Flask(__name__)

cred = credentials.Certificate('spokes-7f290-firebase-adminsdk-z9kcp-6a642e1851.json')
default_app = firebase_admin.initialize_app(cred)

@app.route('/requestUID', methods=['POST'])
def foo():
    email = request.data.decode("utf-8")
    print(request.data)
    print(email)
    user = auth.get_user_by_email(email)
    return user.uid

if __name__ == '__main__':
    app.run(port='5000', host="0.0.0.0")