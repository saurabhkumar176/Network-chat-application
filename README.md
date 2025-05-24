# 💬 Network Chat Application (Java Sockets)

This is a simple **network-based chat application** using **Java socket programming**. It enables multiple clients to connect to a server and chat with each other in real time.

---

## 📂 Project Structure

network-chat-app/
├── ChatServer.java # Server-side code
└── ChatClient.java # Client-side code

yaml
Copy
Edit

---

## 🚀 Features

- Multi-client support using threads
- Broadcast messages to all connected clients
- Real-time messaging over TCP
- Simple command-line interface

---

## 🔧 Requirements

- Java JDK 8 or above
- Terminal or command prompt

---

## ⚙️ How to Run

### 1. Compile Both Files

```bash
javac ChatServer.java
javac ChatClient.java
2. Run the Server
bash
Copy
Edit
java ChatServer
Output:

nginx
Copy
Edit
Server started on port 5000...
3. Run the Client(s) in Separate Terminals
bash
Copy
Edit
java ChatClient
Output:

pgsql
Copy
Edit
Connected to server on port 5000.
💡 You can open multiple clients to simulate a group chat!

📌 Notes
The server listens on port 5000

Clients must connect to the same port and host (localhost)

The server broadcasts messages to all connected clients

🧠 How It Works
Server (ChatServer.java)

Listens for incoming connections

Spawns a new thread for each client

Broadcasts incoming messages to all clients

Client (ChatClient.java)

Connects to server

Sends user input to server

Receives and displays messages from server

🧪 Example
arduino
Copy
Edit
Client 1: Hi everyone!
Client 2: Hello!
Client 3: Good morning!
All messages are displayed to all connected clients via the server.

📃 License
This project is released under the MIT License.

