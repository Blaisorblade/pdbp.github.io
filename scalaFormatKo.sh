#! /bin/bash

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! preprocessing with sed !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

sed -i "s/type Kleisli/\/\/type Kleisli/g" ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala

echo "!!!!!!!!!!!!!!!!!!"
echo "!!! formatting !!!"
echo "!!!!!!!!!!!!!!!!!!"

echo ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala
scalafmt ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! postprocessing with sed !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

sed -i "s/\/\/type Kleisli/type Kleisli/g" ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala