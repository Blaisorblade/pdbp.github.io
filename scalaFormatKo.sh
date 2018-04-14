#! /bin/bash

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! preprocessing with sed !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

sed -i "s/type Kleisli/\/\/type Kleisli/g" ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala

sed -i "s/trait MeaningOfContaining/class MeaningOfContaining/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/trait MeaningOfBox/class MeaningOfBox/g" ./src/main/scala/demo/LibraryLevelMeaning.scala

# appendices

sed -i "s/trait Description/class Description/g" ./src/main/scala/demo/DefiningDescriptions.scala
sed -i "s/trait SomeValuesContainedIn/class SomeValuesContainedIn/g" ./src/main/scala/demo/DefiningDescriptions.scala

echo "!!!!!!!!!!!!!!!!!!"
echo "!!! formatting !!!"
echo "!!!!!!!!!!!!!!!!!!"

echo ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala
scalafmt ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala

echo ./src/main/scala/demo/LibraryLevelMeaning.scala
scalafmt ./src/main/scala/demo/LibraryLevelMeaning.scala

# appendices

echo ./src/main/scala/demo/DefiningDescriptions.scala
scalafmt ./src/main/scala/demo/DefiningDescriptions.scala

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! postprocessing with sed !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

sed -i "s/\/\/type Kleisli/type Kleisli/g" ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala

sed -i "s/class MeaningOfContaining/trait MeaningOfContaining/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/class MeaningOfBox/trait MeaningOfBox/g" ./src/main/scala/demo/LibraryLevelMeaning.scala

# appendices

sed -i "s/class Description/trait Description/g" ./src/main/scala/demo/DefiningDescriptions.scala
sed -i "s/class SomeValuesContainedIn/trait SomeValuesContainedIn/g" ./src/main/scala/demo/DefiningDescriptions.scala
