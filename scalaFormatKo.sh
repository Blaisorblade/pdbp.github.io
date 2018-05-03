#! /bin/bash

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! preprocessing with sed !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

sed -i "s/type Kleisli/\/\/type Kleisli/g" ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala

# appendices

sed -i "s/trait Description/class Description/g" ./src/main/scala/demo/DefiningDescriptions.scala
sed -i "s/trait SomeValuesContainedIn/class SomeValuesContainedIn/g" ./src/main/scala/demo/DefiningDescriptions.scala
sed -i "s/trait SomeValuesCoveredBy/class SomeValuesCoveredBy/g" ./src/main/scala/demo/DefiningDescriptions.scala
sed -i "s/trait ContainingMeaningOfContaining/class ContainingMeaningOfContaining/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/trait ContainingMeaningOfBox/class ContainingMeaningOfBox/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/trait CoveringMeaningOfContaining/class CoveringMeaningOfContaining/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/trait CoveringMeaningOfBox/class CoveringMeaningOfBox/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/trait ContainingMeaningOfCovering/class ContainingMeaningOfCovering/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/trait ContainingMeaningOfCap/class ContainingMeaningOfCap/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/trait ProductInTermsOfLetAndIn/class ProductInTermsOfLetAndIn/g" ./src/main/scala/demo/ProductInTermsOfLetAndIn.scala
sed -i "s/trait SumInTermsOfIfAndElse/class SumInTermsOfIfAndElse/g" ./src/main/scala/demo/SumInTermsOfIfAndElse.scala

echo "!!!!!!!!!!!!!!!!!!"
echo "!!! formatting !!!"
echo "!!!!!!!!!!!!!!!!!!"

echo ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala
scalafmt ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala

# appendices

echo ./src/main/scala/demo/DefiningDescriptions.scala
scalafmt ./src/main/scala/demo/DefiningDescriptions.scala
echo ./src/main/scala/demo/LibraryLevelMeaning.scala
scalafmt ./src/main/scala/demo/LibraryLevelMeaning.scala
echo ./src/main/scala/demo/ProductInTermsOfLetAndIn.scala
scalafmt ./src/main/scala/demo/ProductInTermsOfLetAndIn.scala
echo ./src/main/scala/demo/SumInTermsOfIfAndElse.scala
scalafmt ./src/main/scala/demo/SumInTermsOfIfAndElse.scala

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! postprocessing with sed !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

sed -i "s/\/\/type Kleisli/type Kleisli/g" ./src/main/scala/pdbp/types/kleisli/kleisliFunctionType.scala

# appendices

sed -i "s/class Description/trait Description/g" ./src/main/scala/demo/DefiningDescriptions.scala
sed -i "s/class SomeValuesContainedIn/trait SomeValuesContainedIn/g" ./src/main/scala/demo/DefiningDescriptions.scala
sed -i "s/class SomeValuesCoveredBy/trait SomeValuesCoveredBy/g" ./src/main/scala/demo/DefiningDescriptions.scala
sed -i "s/class ContainingMeaningOfContaining/trait ContainingMeaningOfContaining/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/class ContainingMeaningOfBox/trait ContainingMeaningOfBox/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/class CoveringMeaningOfContaining/trait CoveringMeaningOfContaining/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/class CoveringMeaningOfBox/trait CoveringMeaningOfBox/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/class ContainingMeaningOfCovering/trait ContainingMeaningOfCovering/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/class ContainingMeaningOfCap/trait ContainingMeaningOfCap/g" ./src/main/scala/demo/LibraryLevelMeaning.scala
sed -i "s/class ProductInTermsOfLetAndIn/trait ProductInTermsOfLetAndIn/g" ./src/main/scala/demo/ProductInTermsOfLetAndIn.scala
sed -i "s/class SumInTermsOfIfAndElse/trait SumInTermsOfIfAndElse/g" ./src/main/scala/demo/SumInTermsOfIfAndElse.scala
