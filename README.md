I made this project when I first learnt about the basic socket programming in Java. 
I took this lesson from the Java tutorials available on the Oracle website at the URL:
https://docs.oracle.com/javase/tutorial/networking/sockets/definition.html

In this project, basically we are creating a Socket connection between a client and a server. Here, to illustrate the utility of Socket class available in java.net package, we are using an Echo Protocol (Ref.:https://tools.ietf.org/html/rfc862) for connection between a client and a server

The client writes data entered by a user onto the Socket established between it and the Server. The server listens to it on the ServerSocket and then echoes it back to the client.
