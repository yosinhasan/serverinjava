#!/bin/bash

javac -d ../bin server/*.java

java -cp ../bin server.Server

