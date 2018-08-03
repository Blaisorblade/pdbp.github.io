#! /bin/bash

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! preprocessing with sed !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

sed -i "s/type /\/\/type /g" src/main/scala/pdbp/types/implicitFunctionType.scala
sed -i "s/type /\/\/type /g" src/main/scala/pdbp/types/const/constType.scala
sed -i "s/type /\/\/type /g" src/main/scala/pdbp/examples/utils/EffectfulUtils.scala
sed -i "s/type /\/\/type /g" src/main/scala/pdbp/examples/kleisliPrograms/SumOfSquaresAsExpression.scala
sed -i "s/type /\/\/type /g" src/main/scala/pdbp/examples/kleisliPrograms/HelperKleisliPrograms.scala
sed -i "s/type /\/\/type /g" src/main/scala/pdbp/examples/kleisliPrograms/AtomicKleisliPrograms.scala

sed -i "s/private\[pdbp\] type /\/\/private\[pdbp\] type /g" src/main/scala/pdbp/types/kleisli/kleisliBinaryTypeConstructorType.scala
sed -i "s/private\[pdbp\] type /\/\/private\[pdbp\] type /g" src/main/scala/pdbp/types/kleisli/kleisliUnaryTypeConstructorType.scala
sed -i "s/private\[pdbp\] type /\/\/private\[pdbp\] type /g" src/main/scala/pdbp/computation/transformation/reading/ReadingTransformation.scala
sed -i "s/private\[pdbp\] type /\/\/private\[pdbp\] type /g" src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala
sed -i "s/private\[pdbp\] type /\/\/private\[pdbp\] type /g" src/main/scala/pdbp/computation/transformation/writing/WritingTransformation.scala

sed -i "s/private\[pdbp\] lazy /\/\/private\[pdbp\] lazy /g" src/main/scala/pdbp/program/meaning/ProgramMeaning.scala

sed -i "s/trait /class /g" src/main/scala/pdbp/program/writing/Writing.scala
sed -i "s/trait /class /g" src/main/scala/pdbp/examples/utils/EffectfulUtils.scala
sed -i "s/trait /class /g" src/main/scala/pdbp/examples/kleisliPrograms/HelperKleisliPrograms.scala
sed -i "s/trait /class /g" src/main/scala/pdbp/examples/kleisliPrograms/AtomicKleisliPrograms.scala
sed -i "s/trait /class /g" src/main/scala/examples/programs/AtomicPrograms.scala
sed -i "s/trait /class /g" src/main/scala/examples/programs/HelperPrograms.scala
sed -i "s/trait /class /g" src/main/scala/examples/utils/EffectfulUtils.scala
#demo
sed -i "s/trait /class /g" src/main/scala/demo/meaningsOfImplementedDescriptions.scala
sed -i "s/trait /class /g" src/main/scala/demo/ProductInTermsOfLetAndIn.scala
sed -i "s/trait /class /g" src/main/scala/demo/definingDescriptions.scala
sed -i "s/trait /class /g" src/main/scala/demo/SumInTermsOfIfAndElse.scala

sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/program/implicits/active/reading/writing/ActiveReadingWithWritingProgram.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/program/implicits/active/writing/ActiveWritingProgram.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/program/meaning/ProgramMeaning.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/computation/meaning/reading/ReadingTransformedMeaning.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/computation/meaning/writing/toConsole/WritingToConsoleTransformedMeaning.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/computation/meaning/ofActive/MeaningOfActive.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/computation/meaning/free/FreeTransformedMeaning.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/computation/transformation/reading/ReadingTransformation.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala
sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" src/main/scala/pdbp/computation/transformation/writing/WritingTransformation.scala


echo "!!!!!!!!!!!!!!!!!!"
echo "!!! formatting !!!"
echo "!!!!!!!!!!!!!!!!!!"

echo src/main/scala/pdbp/types/implicitFunctionType.scala
scalafmt src/main/scala/pdbp/types/implicitFunctionType.scala

echo src/main/scala/pdbp/types/const/constType.scala
scalafmt src/main/scala/pdbp/types/const/constType.scala

echo src/main/scala/pdbp/types/kleisli/kleisliBinaryTypeConstructorType.scala
scalafmt src/main/scala/pdbp/types/kleisli/kleisliBinaryTypeConstructorType.scala

echo src/main/scala/pdbp/types/kleisli/kleisliUnaryTypeConstructorType.scala
scalafmt src/main/scala/pdbp/types/kleisli/kleisliUnaryTypeConstructorType.scala

echo src/main/scala/pdbp/program/implicits/active/reading/writing/ActiveReadingWithWritingProgram.scala
scalafmt src/main/scala/pdbp/program/implicits/active/reading/writing/ActiveReadingWithWritingProgram.scala

echo src/main/scala/pdbp/program/implicits/active/writing/ActiveWritingProgram.scala
scalafmt src/main/scala/pdbp/program/implicits/active/writing/ActiveWritingProgram.scala

echo src/main/scala/pdbp/program/meaning/ProgramMeaning.scala
scalafmt src/main/scala/pdbp/program/meaning/ProgramMeaning.scala

echo src/main/scala/pdbp/program/writing/Writing.scala
scalafmt src/main/scala/pdbp/program/writing/Writing.scala

echo src/main/scala/pdbp/computation/meaning/reading/ReadingTransformedMeaning.scala
scalafmt src/main/scala/pdbp/computation/meaning/reading/ReadingTransformedMeaning.scala

echo src/main/scala/pdbp/computation/meaning/writing/toConsole/WritingToConsoleTransformedMeaning.scala
scalafmt src/main/scala/pdbp/computation/meaning/writing/toConsole/WritingToConsoleTransformedMeaning.scala

echo src/main/scala/pdbp/computation/meaning/ofActive/MeaningOfActive.scala
scalafmt src/main/scala/pdbp/computation/meaning/ofActive/MeaningOfActive.scala

echo src/main/scala/pdbp/computation/meaning/free/FreeTransformedMeaning.scala
scalafmt src/main/scala/pdbp/computation/meaning/free/FreeTransformedMeaning.scala

echo src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala
scalafmt src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala

echo src/main/scala/pdbp/computation/transformation/reading/ReadingTransformation.scala
scalafmt src/main/scala/pdbp/computation/transformation/reading/ReadingTransformation.scala

echo src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala
scalafmt src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala

echo src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala
scalafmt src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala

echo src/main/scala/pdbp/computation/transformation/writing/WritingTransformation.scala
scalafmt src/main/scala/pdbp/computation/transformation/writing/WritingTransformation.scala

echo src/main/scala/pdbp/examples/utils/EffectfulUtils.scala
scalafmt src/main/scala/pdbp/examples/utils/EffectfulUtils.scala

echo src/main/scala/pdbp/examples/kleisliPrograms/SumOfSquaresAsExpression.scala
scalafmt src/main/scala/pdbp/examples/kleisliPrograms/SumOfSquaresAsExpression.scala

echo src/main/scala/pdbp/examples/kleisliPrograms/HelperKleisliPrograms.scala
scalafmt src/main/scala/pdbp/examples/kleisliPrograms/HelperKleisliPrograms.scala

echo src/main/scala/pdbp/examples/kleisliPrograms/AtomicKleisliPrograms.scala
scalafmt src/main/scala/pdbp/examples/kleisliPrograms/AtomicKleisliPrograms.scala

echo src/main/scala/examples/programs/AtomicPrograms.scala
scalafmt src/main/scala/examples/programs/AtomicPrograms.scala

echo src/main/scala/examples/programs/HelperPrograms.scala
scalafmt src/main/scala/examples/programs/HelperPrograms.scala

echo src/main/scala/examples/utils/EffectfulUtils.scala
scalafmt src/main/scala/examples/utils/EffectfulUtils.scala

#demo

echo src/main/scala/demo/meaningsOfImplementedDescriptions.scala
scalafmt src/main/scala/demo/meaningsOfImplementedDescriptions.scala

echo src/main/scala/demo/ProductInTermsOfLetAndIn.scala
scalafmt src/main/scala/demo/ProductInTermsOfLetAndIn.scala

echo src/main/scala/demo/definingDescriptions.scala
scalafmt src/main/scala/demo/definingDescriptions.scala

echo src/main/scala/demo/SumInTermsOfIfAndElse.scala
scalafmt src/main/scala/demo/SumInTermsOfIfAndElse.scala

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! postprocessing with sed !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

sed -i "s/\/\/type /type /g" src/main/scala/pdbp/types/implicitFunctionType.scala
sed -i "s/\/\/type /type /g" src/main/scala/pdbp/types/const/constType.scala
sed -i "s/\/\/type /type /g" src/main/scala/pdbp/examples/utils/EffectfulUtils.scala
sed -i "s/\/\/type /type /g" src/main/scala/pdbp/examples/kleisliPrograms/SumOfSquaresAsExpression.scala
sed -i "s/\/\/type /type /g" src/main/scala/pdbp/examples/kleisliPrograms/HelperKleisliPrograms.scala
sed -i "s/\/\/type /type /g" src/main/scala/pdbp/examples/kleisliPrograms/AtomicKleisliPrograms.scala

sed -i "s/\/\/private\[pdbp\] type /private\[pdbp\] type /g" src/main/scala/pdbp/types/kleisli/kleisliBinaryTypeConstructorType.scala
sed -i "s/\/\/private\[pdbp\] type /private\[pdbp\] type /g" src/main/scala/pdbp/types/kleisli/kleisliUnaryTypeConstructorType.scala
sed -i "s/\/\/private\[pdbp\] type /private\[pdbp\] type /g" src/main/scala/pdbp/computation/transformation/reading/ReadingTransformation.scala
sed -i "s/\/\/private\[pdbp\] type /private\[pdbp\] type /g" src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala
sed -i "s/\/\/private\[pdbp\] type /private\[pdbp\] type /g" src/main/scala/pdbp/computation/transformation/writing/WritingTransformation.scala

sed -i "s/\/\/private\[pdbp\] lazy /private\[pdbp\] lazy /g" src/main/scala/pdbp/program/meaning/ProgramMeaning.scala

sed -i "s/class /trait /g" src/main/scala/pdbp/program/writing/Writing.scala
sed -i "s/class /trait /g" src/main/scala/pdbp/examples/utils/EffectfulUtils.scala
sed -i "s/class /trait /g" src/main/scala/pdbp/examples/kleisliPrograms/HelperKleisliPrograms.scala
sed -i "s/class /trait /g" src/main/scala/pdbp/examples/kleisliPrograms/AtomicKleisliPrograms.scala
sed -i "s/class /trait /g" src/main/scala/examples/programs/AtomicPrograms.scala
sed -i "s/class /trait /g" src/main/scala/examples/programs/HelperPrograms.scala
sed -i "s/class /trait /g" src/main/scala/examples/utils/EffectfulUtils.scala
#demo
sed -i "s/class /trait /g" src/main/scala/demo/meaningsOfImplementedDescriptions.scala
sed -i "s/class /trait /g" src/main/scala/demo/ProductInTermsOfLetAndIn.scala
sed -i "s/class /trait /g" src/main/scala/demo/definingDescriptions.scala
sed -i "s/class /trait /g" src/main/scala/demo/SumInTermsOfIfAndElse.scala

sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/program/implicits/active/reading/writing/ActiveReadingWithWritingProgram.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/program/implicits/active/writing/ActiveWritingProgram.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/program/meaning/ProgramMeaning.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/computation/meaning/reading/ReadingTransformedMeaning.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/computation/meaning/writing/toConsole/WritingToConsoleTransformedMeaning.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/computation/meaning/ofActive/MeaningOfActive.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/computation/meaning/free/FreeTransformedMeaning.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/computation/transformation/reading/ReadingTransformation.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala
sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" src/main/scala/pdbp/computation/transformation/writing/WritingTransformation.scala

echo "!!!!!!!!!!!!!!!!"
echo "!!! skipping !!!"
echo "!!!!!!!!!!!!!!!!"

echo src/main/scala/pdbp/computation/transformation/reading/writing/ReadingWithWritingTransformation.scala
echo src/main/scala/examples/programs/reading/int/FactorialMultipliedByIntRead.scala
echo src/main/scala/examples/programs/writing/utils/infoUtils.scala
echo src/main/scala/examples/programs/writing/WritingAtomicPrograms.scala
echo src/main/scala/examples/programs/writing/WritingFactorial.scala
echo src/main/scala/examples/mainPrograms/reading/int/effectfulWriting/MainFactorialMultipliedByIntRead.scala
echo src/main/scala/examples/mainPrograms/reading/int/effectfulWriting/MainFactorialOfIntRead.scala
echo src/main/scala/examples/mainPrograms/writing/toConsole/effectfulReading/MainFactorialWrittenToConsole.scala
echo src/main/scala/examples/mainPrograms/reading/int/writing/toConsole/MainFactorialOfIntReadWrittenToConsole.scala
echo src/main/scala/examples/mainPrograms/reading/int/writing/toConsole/MainFactorialOfIntReadWritingToConsoleWrittenToConsole.scala
echo src/main/scala/examples/mainPrograms/reading/int/writing/toConsole/effectfulWriting/MainFactorialOfIntReadWritingToConsole.scala

echo "!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "!!! checking with sbt !!!"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!"


sbt clean

sbt compile



