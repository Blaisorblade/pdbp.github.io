#! /bin/bash

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! preprocessing with sed !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

sed -i "s/type Kleisli/\/\/type Kleisli/g" ./src/main/scala/pdbp/types/kleisli/kleisliProgramType.scala
sed -i "s/type FreeTransformed/\/\/type FreeTransformed/g" ./src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala

sed -i "s/trait FactorialMain/class FactorialMain/g" ./src/main/scala/examples/mainPrograms/effectfulReadingAndWriting/FactorialMain.scala
sed -i "s/trait ProgramMeaning/class ProgramMeaning/g" ./src/main/scala/pdbp/program/meaning/ProgramMeaning.scala
sed -i "s/trait ComputationMeaning/class ComputationMeaning/g" ./src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala
sed -i "s/trait MeaningOfActive/class MeaningOfActive/g" ./src/main/scala/pdbp/computation/meaning/instances/ofActive/MeaningOfActive.scala
sed -i "s/trait ComputationTransformation/class ComputationTransformation/g" ./src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala
sed -i "s/trait FreeTransformation/class FreeTransformation/g" ./src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala

# appendices

sed -i "s/type Kleisli/\/\/type Kleisli/g" ./src/main/scala/pdbp/demo/types/kleisli/kleisliComputationType.scala

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

echo ./src/main/scala/pdbp/types/kleisli/kleisliProgramType.scala
scalafmt ./src/main/scala/pdbp/types/kleisli/kleisliProgramType.scala

echo ./src/main/scala/examples/mainPrograms/effectfulReadingAndWriting/FactorialMain.scala
scalafmt ./src/main/scala/examples/mainPrograms/effectfulReadingAndWriting/FactorialMain.scala
echo ./src/main/scala/pdbp/program/meaning/ProgramMeaning.scala
scalafmt ./src/main/scala/pdbp/program/meaning/ProgramMeaning.scala
echo ./src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala
scalafmt ./src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala
echo ./src/main/scala/pdbp/computation/meaning/instances/ofActive/MeaningOfActive.scala
scalafmt ./src/main/scala/pdbp/computation/meaning/instances/ofActive/MeaningOfActive.scala
echo ./src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala
scalafmt ./src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala
echo ./src/main/scala/pdbp/computation/transformation/free/FreeComputationTransformation.scala
scalafmt ./src/main/scala/pdbp/computation/transformation/free/FreeComputationTransformation.scala

# appendices

echo ./src/main/scala/pdbp/demo/types/kleisli/kleisliComputationType.scala
scalafmt ./src/main/scala/pdbp/demo/types/kleisli/kleisliComputationType.scala

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

sed -i "s/\/\/type Kleisli/type Kleisli/g" ./src/main/scala/pdbp/types/kleisli/kleisliProgramType.scala
sed -i "s/type FreeTransformed/\/\/type FreeTransformed/g" ./src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala

sed -i "s/class FactorialMain/trait FactorialMain/g" ./src/main/scala/examples/mainPrograms/effectfulReadingAndWriting/FactorialMain.scala
sed -i "s/class ProgramMeaning/trait ProgramMeaning/g" ./src/main/scala/pdbp/program/meaning/ProgramMeaning.scala
sed -i "s/class ComputationMeaning/trait ComputationMeaning/g" ./src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala
sed -i "s/class MeaningOfActive/trait MeaningOfActive/g" ./src/main/scala/pdbp/computation/meaning/instances/ofActive/MeaningOfActive.scala
sed -i "s/class ComputationTransformation/trait ComputationTransformation/g" ./src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala
sed -i "s/class FreeTransformation/trait FreeTransformation/g" ./src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala

# appendices

sed -i "s/\/\/type Kleisli/type Kleisli/g" ./src/main/scala/pdbp/demo/types/kleisli/kleisliComputationType.scala

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
