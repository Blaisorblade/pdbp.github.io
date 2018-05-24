#! /bin/bash

echo "!!!!!!!!!!!!!!!!!!"
echo "!!! formatting !!!"
echo "!!!!!!!!!!!!!!!!!!"

for f in $(find . -name "*.scala")
do
echo $f
if [[ "$f" == "./src/main/scala/pdbp/types/kleisli/kleisliProgramType.scala" || 

      "$f" == "./src/main/scala/examples/mainPrograms/effectfulReadingAndWriting/FactorialMain.scala" ||
      "$f" == "./src/main/scala/pdbp/program/meaning/ProgramMeaning.scala" ||
      "$f" == "./src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala" ||
      "$f" == "./src/main/scala/pdbp/computation/meaning/instances/ofActive/MeaningOfActive.scala" ||
      "$f" == "./src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala" ||
      "$f" == "./src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala" ||
      "$f" == "./src/main/scala/pdbp/computation/meaning/free/FreeTransformedMeaning.scala" ||
      "$f" == "./src/main/scala/pdbp/computation/transformation/reading/ReadingTransformation.scala" ||
      
      "$f" == "./src/main/scala/pdbp/demo/types/kleisli/kleisliComputationType.scala" ||

      "$f" == "./src/main/scala/demo/DefiningDescriptions.scala" ||
      "$f" == "./src/main/scala/demo/LibraryLevelMeaning.scala" ||
      "$f" == "./src/main/scala/demo/ProductInTermsOfLetAndIn.scala" ||
      "$f" == "./src/main/scala/demo/SumInTermsOfIfAndElse.scala" ]]
then
  echo "skipping"
else
  echo "formatting"
  scalafmt $f
fi
done

