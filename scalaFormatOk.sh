#! /bin/bash

echo "!!!!!!!!!!!!!!!!!!"
echo "!!! formatting !!!"
echo "!!!!!!!!!!!!!!!!!!"

for f in $(find . -name "*.scala")
do
echo $f
if [[ "$f" == "./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala" ]]
then
  echo "skipping"
else
  echo "formatting"
  scalafmt $f
fi
done

