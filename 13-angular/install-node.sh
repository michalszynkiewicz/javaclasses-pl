#!/bin/bash

rm -rf ~/bin/node

wget https://nodejs.org/dist/v8.11.2/node-v8.11.2-linux-x64.tar.xz -O /tmp/node.tgz

mkdir -p ~/bin/node
cd ~/bin/node
tar -xf /tmp/node.tgz

nodeDir=$(find . -maxdepth 1 -type d ! -path .)
mv $nodeDir/* .
rm -rf $nodeDir

echo "export PATH=\"\$PATH:$(pwd)/bin\"" >> ~/.profile

source ~/.profile
