#! /bin/bash

for f in $(find src -name "*.scala")
do
echo "=================================="
echo $f
scalafmt $f
echo "=================================="
done

