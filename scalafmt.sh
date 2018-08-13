#! /bin/bash

for f in $(find src -name "*.scala")
do
  if [[ $f -ef src/main/scala/pdbp/utils/productUtils.scala ||
        $f -ef src/main/scala/pdbp/utils/functionUtils.scala ||
        $f -ef src/main/scala/pdbp/utils/sumUtils.scala ||
        $f -ef src/main/scala/pdbp/utils/productAndSumUtils.scala ||
        $f -ef src/main/scala/pdbp/utils/effectfulUtils.scala ||
        $f -ef src/main/scala/pdbp/types/effect/effectType.scala ||
        $f -ef src/main/scala/pdbp/types/effect/toConsole/ToConsole.scala ||
        $f -ef src/main/scala/pdbp/types/sum/sumType.scala ||
        $f -ef src/main/scala/pdbp/types/active/reading/activeReadingTypes.scala ||
        $f -ef src/main/scala/pdbp/types/active/reading/writing/activeReadingWithWritingTypes.scala ||
        $f -ef src/main/scala/pdbp/types/active/activeTypes.scala ||
        $f -ef src/main/scala/pdbp/types/active/free/activeFreeTypes.scala ||
        $f -ef src/main/scala/pdbp/types/active/writing/activeWritingTypes.scala ||
        $f -ef src/main/scala/pdbp/types/product/productType.scala ||
        $f -ef src/main/scala/pdbp/writable/implicits/toConsole/implicits.scala ||
        $f -ef src/main/scala/pdbp/writable/Startable.scala ||
        $f -ef src/main/scala/pdbp/writable/Appendable.scala ||
        $f -ef src/main/scala/pdbp/writable/Writable.scala || 
        $f -ef src/main/scala/pdbp/program/reading/Reading.scala || 
        $f -ef src/main/scala/pdbp/program/Composition.scala ||
        $f -ef src/main/scala/pdbp/program/active/reading/int/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/active/reading/int/writing/toConsole/implicits.scala || 
        $f -ef src/main/scala/pdbp/program/active/reading/ActiveReadingProgram.scala ||
        $f -ef src/main/scala/pdbp/program/active/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/active/free/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/active/writing/toConsole/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/reactive/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/Program.scala ||
        $f -ef src/main/scala/pdbp/program/meaning/ofActive/active/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/meaning/ofActiveFree/active/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/meaning/ofActiveWritingToConsole/active/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/meaning/ofActiveIntReadingWithWritingToConsole/activeIntReading/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/meaning/ofActiveIntReading/activeIntReading/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/meaning/ofReactive/reactive/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/meaning/ofReactiveFree/reactive/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/Applying.scala ||
        $f -ef src/main/scala/pdbp/program/Construction.scala ||
        $f -ef src/main/scala/pdbp/program/Function.scala ||
        $f -ef src/main/scala/pdbp/program/Aggregation.scala ||
        $f -ef src/main/scala/pdbp/program/Condition.scala ||
        $f -ef src/main/scala/pdbp/program/ProgramWithApplying.scala || 
        $f -ef src/main/scala/pdbp/computation/Sequencing.scala ||
        $f -ef src/main/scala/pdbp/computation/Computation.scala ||
        $f -ef src/main/scala/pdbp/computation/OperatorLifting.scala ||
        $f -ef src/main/scala/pdbp/computation/ObjectLifting.scala ||
        $f -ef src/main/scala/pdbp/computation/FunctionLifting.scala ||
        $f -ef src/main/scala/pdbp/computation/Resulting.scala ||
        $f -ef src/main/scala/pdbp/computation/Binding.scala ||
        $f -ef src/main/scala/pdbp/computation/Lifting.scala ||
        $f -ef src/main/scala/pdbp/examples/main/active/effectfulReadingAndWriting/SumOfSquaresMain.scala ||
        $f -ef src/main/scala/pdbp/examples/main/active/effectfulReadingAndWriting/FactorialMain.scala ||
        $f -ef src/main/scala/pdbp/examples/main/reactive/effectfulReadingAndWriting/FactorialMain.scala ||
        $f -ef src/main/scala/pdbp/examples/utils/functionUtils.scala ||
        $f -ef src/main/scala/pdbp/examples/kleisliPrograms/SumOfSquares.scala ||
        $f -ef src/main/scala/pdbp/examples/kleisliPrograms/Factorial.scala ||
        $f -ef src/main/scala/pdbp/natural/transformation/binary/NaturalBinaryTypeConstructorTransformation.scala ||
        $f -ef src/main/scala/pdbp/natural/transformation/unary/NaturalUnaryTypeConstructorTransformation.scala ||
        $f -ef src/main/scala/demo/FunctionsAndExpressions.scala ||
        $f -ef src/main/scala/demo/resulting.scala ||
        $f -ef src/main/scala/demo/Variance.scala ||
        $f -ef src/main/scala/demo/bindingOperator.scala ||
        $f -ef src/main/scala/demo/definingDescriptions.scala ||
        $f -ef src/main/scala/demo/implementingDescriptions.scala ||
        $f -ef src/main/scala/examples/utils/EffectfulUtils.scala ||
        $f -ef src/main/scala/examples/programs/Factorial.scala ||
        $f -ef src/main/scala/examples/programs/FactorialAsFunction.scala ||
        $f -ef src/main/scala/examples/programs/FactorialTopDown.scala ||
        $f -ef src/main/scala/examples/main/active/reading/int/effectfulWriting/FactorialOfIntReadMain.scala ||
        $f -ef src/main/scala/examples/main/active/reading/int/effectfulReadingAndWriting/FactorialMultipliedByIntReadMain.scala ||
        $f -ef src/main/scala/examples/main/active/reading/int/writing/toConsole/FactorialOfIntReadWrittenToConsoleMain.scala ||
        $f -ef src/main/scala/examples/main/active/reading/int/writing/toConsole/FactorialOfIntReadWritingToConsoleWrittenToConsoleMain.scala ||
        $f -ef src/main/scala/examples/main/active/effectfulReadingAndWriting/FactorialMain.scala ||
        $f -ef src/main/scala/examples/main/active/free/effectfulReadingAndWriting/FactorialMain.scala ||
        $f -ef src/main/scala/examples/main/active/writing/toConsole/effectfulReading/FactorialWrittenToConsoleMain.scala ||
        $f -ef src/main/scala/examples/main/reactive/effectfulReadingAndWriting/FactorialMain.scala ||
        $f -ef src/main/scala/examples/utils/effects/implicits.scala ||
        $f -ef src/main/scala/examples/utils/functionUtils.scala ||
        $f -ef src/main/scala/pdbp/types/reactive/reactiveTypes.scala ||
        $f -ef src/main/scala/pdbp/types/reactive/reading/reactiveReadingTypes.scala ||
        $f -ef src/main/scala/pdbp/types/reactive/writing/reactiveWritingTypes.scala ||
        $f -ef src/main/scala/pdbp/types/reactive/reading/writing/reactiveReadingWithWritingTypes.scala ||
        $f -ef src/main/scala/pdbp/program/reactive/free/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/reactive/reading/ReactiveReadingProgram.scala ||
        $f -ef src/main/scala/pdbp/program/reactive/reading/int/implicits.scala ||
        $f -ef src/main/scala/pdbp/program/reactive/writing/toConsole/implicits.scala || 
        $f -ef src/main/scala/pdbp/program/reactive/reading/int/writing/toConsole/implicits.scala || 
        $f -ef src/main/scala/examples/main/reactive/free/effectfulReadingAndWriting/FactorialMain.scala ||
        $f -ef src/main/scala/examples/main/reactive/reading/int/effectfulWriting/FactorialOfIntReadMain.scala ||
        $f -ef src/main/scala/pdbp/program/meaning/ofReactiveWritingToConsole/reactive/implicits.scala ]]
  then
    echo "scalafmt $f"
    scalafmt $f
  elif [[ $f -ef src/main/scala/pdbp/types/implicitFunctionType.scala ||
          $f -ef src/main/scala/pdbp/types/const/constType.scala || 
          $f -ef src/main/scala/pdbp/examples/kleisliPrograms/SumOfSquaresAsExpression.scala ]]
  then
    echo "scalafmt $f has problems with 'type '"
    sed -i "s/type /\/\/type /g" $f
    scalafmt $f
    sed -i "s/\/\/type /type /g" $f
  elif [[ $f -ef src/main/scala/pdbp/program/writing/Writing.scala ||
          $f -ef src/main/scala/demo/ProductInTermsOfLetAndIn.scala ||
          $f -ef src/main/scala/demo/SumInTermsOfIfAndElse.scala ||
          $f -ef src/main/scala/demo/meaningsOfImplementedDescriptions.scala ||
          $f -ef src/main/scala/pdbp/examples/kleisliPrograms/SumOfSquaresAsExpression.scala ||
          $f -ef src/main/scala/examples/programs/AtomicPrograms.scala ||
          $f -ef src/main/scala/examples/programs/HelperPrograms.scala ||
          $f -ef src/main/scala/examples/mainPrograms/MainFactorial.scala ]]
  then
    echo "scalafmt $f has problems with 'trait '"
    sed -i "s/trait /class /g" $f
    scalafmt $f
    sed -i "s/class /trait /g" $f
  elif [[ $f -ef src/main/scala/pdbp/examples/mainKleisliPrograms/MainSumOfSquares.scala ||
          $f -ef src/main/scala/pdbp/examples/mainKleisliPrograms/MainFactorial.scala ||
          $f -ef src/main/scala/pdbp/examples/kleisliPrograms/HelperKleisliPrograms.scala ||
          $f -ef src/main/scala/pdbp/examples/kleisliPrograms/AtomicKleisliPrograms.scala ]]
  then
    echo "scalafmt $f has problems with 'trait '"
    echo "scalafmt $f has problems with 'type '"
    sed -i "s/trait /class /g" $f
    sed -i "s/type /\/\/type /g" $f
    scalafmt $f
    sed -i "s/\/\/type /type /g" $f
    sed -i "s/class /trait /g" $f    
  elif [[ $f -ef src/main/scala/pdbp/types/kleisli/kleisliBinaryTypeConstructorType.scala ||
          $f -ef src/main/scala/pdbp/types/kleisli/kleisliUnaryTypeConstructorType.scala ]]
  then
    echo "scalafmt $f has problems with 'private[pdbp] type '"
    sed -i "s/private\[pdbp\] type /\/\/private\[pdbp\] type /g" $f
    scalafmt $f
    sed -i "s/\/\/private\[pdbp\] type /private\[pdbp\] type /g" $f
  elif [[ $f -ef src/main/scala/pdbp/program/active/reading/writing/ActiveReadingWithWritingProgram.scala ||
          $f -ef src/main/scala/pdbp/program/active/writing/ActiveWritingProgram.scala ||
          $f -ef src/main/scala/pdbp/computation/meaning/reading/ReadingTransformedMeaning.scala ||
          $f -ef src/main/scala/pdbp/computation/meaning/ofActive/MeaningOfActive.scala ||
          $f -ef src/main/scala/pdbp/computation/meaning/free/FreeTransformedMeaning.scala ||
          $f -ef src/main/scala/pdbp/computation/meaning/writing/toConsole/WritingToConsoleTransformedMeaning.scala ||
          $f -ef src/main/scala/pdbp/computation/meaning/ComputationMeaning.scala ||
          $f -ef src/main/scala/pdbp/computation/meaning/IdentityMeaning.scala ||
          $f -ef src/main/scala/pdbp/computation/transformation/ComputationTransformation.scala ||
          $f -ef src/main/scala/pdbp/program/reactive/writing/ReactiveWritingProgram.scala ||
          $f -ef src/main/scala/pdbp/program/reactive/reading/writing/ReactiveReadingWithWritingProgram.scala ]]
  then
    echo "scalafmt $f has problems with 'private[pdbp] trait '"
    sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" $f
    scalafmt $f
    sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" $f
  elif [[ $f -ef src/main/scala/pdbp/computation/transformation/reading/ReadingTransformation.scala ||
          $f -ef src/main/scala/pdbp/computation/transformation/free/FreeTransformation.scala ||
          $f -ef src/main/scala/pdbp/computation/transformation/writing/WritingTransformation.scala ]]
  then
    echo "scalafmt $f has problems with 'private[pdbp] trait '"
    echo "scalafmt $f has problems with 'private[pdbp] type '"
    sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" $f
    sed -i "s/private\[pdbp\] type /\/\/private\[pdbp\] type /g" $f
    scalafmt $f
    sed -i "s/\/\/private\[pdbp\] type /private\[pdbp\] type /g" $f
    sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" $f 
  elif [[ $f -ef src/main/scala/pdbp/program/meaning/ProgramMeaning.scala ]]
  then
    echo "scalafmt $f has problems with 'private[pdbp] trait '"
    echo "scalafmt $f has problems with 'lazy val  '"
    sed -i "s/private\[pdbp\] trait /private\[pdbp\] class /g" $f
    sed -i "s/private\[pdbp\] lazy /\/\/private\[pdbp\] lazy /g" $f
    scalafmt $f
    sed -i "s/\/\/private\[pdbp\] lazy /private\[pdbp\] lazy /g" $f
    sed -i "s/private\[pdbp\] class /private\[pdbp\] trait /g" $f
  elif [[ $f -ef src/main/scala/pdbp/computation/transformation/reading/writing/ReadingWithWritingTransformation.scala ||
          $f -ef src/main/scala/examples/programs/reading/int/FactorialMultipliedByIntRead.scala ||
          $f -ef src/main/scala/examples/programs/writing/utils/infoUtils.scala ||
          $f -ef src/main/scala/examples/programs/writing/WritingAtomicPrograms.scala ||
          $f -ef src/main/scala/examples/programs/writing/WritingFactorial.scala ||
          $f -ef src/main/scala/examples/mainPrograms/reading/int/MainFactorialMultipliedByIntRead.scala ||
          $f -ef src/main/scala/examples/mainPrograms/writing/MainWritingFactorial.scala ||
          $f -ef src/main/scala/pdbp/computation/transformation/reactive/ReactiveTransformation.scala ]]
  then
    echo "scalafmt $f skipped"      
  else
    printf ""
  fi  
done



