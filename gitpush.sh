#!/usr/bin/env sh
echo "Enter Your Message"
read message
echo "Enter Repository"
read repo

git init
git add .
git commit -m "${message}"
git remote add origin "${repo}"
git remote -v
git push origin master