# **Program Description Based Programming**

## **About me**

I worked as a
 - mathematician (research and education)
 - programmer (research, education and consultancy)
 
I am retired now.

I am having fun with Maritza
  - cycling with our race bicycles (climbing mountains, ...)
  - gardening in our green house (lettuce, cauliflower, tomato, bell pepper, ...)

Below is a link to picture, taken by a friend, of me and my wife, cycling in the French Alps.

[Luc and Maritza](./pictures/LucAndMaritza.JPG)

Below is a link to picture of a radish I picked out of my greenhouse 5 minutes ago.

[Radish](./pictures/Radijs.png)

As a hobby I am still
  - programming (bridging the gap between mathematical theory and programming practice)

I hope you enjoy the document below.

All comments are welcome at [ pdbp.blog at gmail.com ]

## **Warning**

First, let me be clear about the following
 - Both this document and the library it describes are opiniated.

Second, this document is work in progress
 - Major changes are documented in section [Changes](#changes).

## **History**

Before starting, let's present a bit of history.

In 1977, [John Backus](https://en.wikipedia.org/wiki/John_Backus) was an [ACM](https://www.acm.org/) [A.M. Turing Award Winner](https://amturing.acm.org/award_winners/backus_0703524.cfm).
The title of his Turing Award winning lecture was 

*Can programming be liberated from the von Neumann style? A functional style and it's algebra of programs.*

This document builds upon the ideas of this influential lecture.

## **Introduction**

When writing an introduction it is challenging to find the right balance between providing *too many* details or *too few* details. 
This introduction provides *many* details. 
It is perfectly fine to read this introduction *diagonally*.


### **Introducing `FP`**

In his Turing Award winning lecture, John Backus describes the [*function level* programming language `FP`](https://en.wikipedia.org/wiki/FP_(programming_language)). 

The `FP` programming language consists of *objects*, *programs*, *forms* and *definitions*, where

 - a program transforms objects to an object,
 - a form transforms programs to a program,
 - a definition defines a program or a form in terms of programs and forms.

Think of forms as *program templates* and programs transformed by them as *program fragments*, or *program components*, that can be plugged into them to obtain a *composite program*.

The `FP` forms are 

 - *Function*
 - *Composition*
 - *Construction*
 - *Condition*
 - *Aggregation*

#### **Note**

`FP` does not really have an *Aggregation* form. 
It does have *sequences of objects* and it is possible to define `FP` programs that *aggregate* sequences of objects to an object.

### **Introducing `PDBP`**

This document describes a *library*, `PDBP`, that is written in the [`Dotty` programming language](http://dotty.epfl.ch/). 
The `PDBP` library implements the `FP` programming language.

Below is the logo of the library

```scala
    //       _______         __    __        _______
    //      / ___  /\       / /\  / /\      / ___  /\
    //     / /__/ / / _____/ / / / /_/__   / /__/ / /
    //    / _____/ / / ___  / / / ___  /\ /____  / /
    //   / /\____\/ / /__/ / / / /__/ / / \___/ / /
    //  /_/ /      /______/ / /______/ /     /_/ /
    //  \_\/       \______\/  \______\/      \_\/
    //                                           v1.0
    //  Program Description Based Programming Library
    //  author        Luc Duponcheel        2017-2018
```

### **Introducing `trait Program`**

The main `Dotty` *type class* of the `PDBP` library is `trait Program`.

```scala
package pdbp.program

trait Program[>-->[- _, + _]]
    extends Function[>-->]
    with Composition[>-->]
    with Construction[>-->]
    with Condition[>-->]
    with Aggregation[>-->]
```

There is a one-to-one correspondence between `FP` forms and `trait`'s that are *mixed-in* by `trait Program`.

`trait Program` closely resembles *arrows*.

In 1998, John Hughes described arrows and used arrows in `Haskell` in
[*Generalizing monads to arrows*](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.29.4575&rep=rep1&type=pdf).

`trait Program` is about *program descriptions*.
Program descriptions are *defined* in terms of *programming capabilities* that are *declared* in `trait Program`.

By abuse of notation, we often simply refer to program descriptions as *programs*. 
We hope that this does not lead to any confusion.

Compare this with the famous painting [Ceci n'est pas une pipe](https://en.wikipedia.org/wiki/The_Treachery_of_Images) of [René Magritte](https://en.wikipedia.org/wiki/Ren%C3%A9_Magritte). 

Below is a link to a picture of the painting.

[Ceci n'est pas une pipe](./pictures/pipe.png)

The painting above is not a pipe, it is a *description* of a pipe.

`trait Program` exposes a *pointfree* programming API for *application developers*.
All it's capabilities are `public`, the default in `Dotty`.

Below is a `factorial` program written using `trait Program`'s API .

```scala
  val factorial: BigInt >--> BigInt =
    `if`(isZero) {
      one
    } `else` {
      `let` {
        subtractOne >-->
          factorial
      } `in` {
        multiply
      }  
    }
```

In a way programs generalize functions. 

 - A function transforms *function arguments* to yield a *function result*. 
 - A program also, *somehow*, transforms *program arguments* to yield a *program result*. 

When there is no danger of confusion we are simply going to write *arguments* and *result*, not mentioning *function* or *program*.

To finish

 - pointfree programming using `trait Program` is *program oriented* and *program composition* based.


### **Introducing `trait Computation`**

Another important `Dotty` type class of the `PDBP` library is `trait Computation`.

```scala
package pdbp.computation

import pdbp.program.Program

private[pdbp] trait Computation[M[+ _]]
    extends Resulting[M]
    with Binding[M]
    with Program[[-Z, + Y] => Z => M[Y]]
    // ...
```
`trait Computation` closely resembles *monads*.

In 1991, Eugenio Moggi described monads in
[*Notions of computation and monads*](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.79.733&rep=rep1&type=pdf).

In 1992, Philip Wadler used monads in `Haskell` in 
[*The essence of functional programming*](http://citeseerx.ist.psu.edu/viewdoc/download;jsessionid=E09A5FD9362F6780675ADF29471B7428?doi=10.1.1.38.9516&rep=rep1&type=pdf).

`trait Computation` is about *computation descriptions*. 
Computation descriptions are defined in terms of *computational capabilities* that are declared in `trait Computation`.

By abuse of notation, we often simply refer to computation descriptions as *computations*. 
We hope that this does not lead to any confusion.

`trait Computation` exposes a *pointful* programming API for *library developers*.
All it's capabilities are `private[pdbp]`.

In a way computations generalize *expressions*. 

 - An expression *evaluation* yields an *expression result*. 
 - A computation *execution* also, *somehow*, yields a *computation result*. 

When there is no danger of confusion we are simply going to write *result*, not mentioning *expression* or *computation*.

To finish

 - pointful programming using `trait Computation` is *computation oriented* and *result binding* based.


### **Power of expression**

In 2008, Conor McBride and Ross Paterson described *applicatives* (a.k.a. *idioms*) and used them in `Haskell` in 
[*Applicative programming with effects*](http://www.staff.city.ac.uk/~ross/papers/Applicative.pdf).

In 2008, Sam Lindley, Philip Wadler and Jeremy Yallop compared the *power of expression* of monads, arrows and idioms in 
[*Idioms are oblivious, arrows are meticulous, monads are promiscuous*](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.187.6750&rep=rep1&type=pdf). 

 - Monads have most power of expression. 
 - Applicatives have least power of expression. 
 - Arrows are in between.

### **Introducing `type Kleisli`**

Recall that

 - Monads naturally lead to a pointful programming style. 
 - Arrows naturally lead to a pointfree programming style. 

But

 - Monad based computations can use a pointfree programming style by making use of [*Kleisli categories*](https://en.wikipedia.org/wiki/Kleisli_category). 
 - Arrow based programs can use a pointful programming style by making use of [*arrow calculus*](http://homepages.inf.ed.ac.uk/slindley/papers/arrow-calculus.pdf).

The `PDBP` library goes for programming monads in a pointfree style using Kleisli categories.

The `with Program[[-Z, + Y] => Z => M[Y]]` part of `trait Computation`, which states that computations have more power of expression than programs, is a bit verbose.

Using the *type alias* `type Kleisli` below

```scala
package pdbp.types.kleisli

object kleisliFunctionType {

  type Kleisli = [M[+ _]] => [-Z, + Y] => Z => M[Y]

}
```

`trait Computation` can be defined as follows

```scala
package pdbp.computation

import pdbp.types.kleisli.kleisliFunctionType.Kleisli

import pdbp.program.Program

private[pdbp] trait Computation[M[+ _]]
    extends Resulting[M]
    with Binding[M]
    with Program[Kleisli[M]]
```  

#### **About functions and expressions (for those who are a bit impatient)**

Recall that

 - In a way, programs generalize functions. 
 - In a way, computations generalize expressions.

[AppendixFunctionsAndExpressions](#appendixfunctionsandexpressions) has demo code that compares 
 - pointful expression oriented and function application (argument binding) based programming,
 - pointfree function oriented and function composition based programming. 

#### **About descriptions (for those who are a bit impatient)**

Recall that

 - Program descriptions are defined in terms of programming capabilities that are declared in the type class `trait Program`.
 - Computation descriptions are defined in terms of computational capabilities that are declared in the type class `trait Computation`.

[AppendixDefiningDescriptions](#appendixdefiningdescriptions) has demo code where descriptions are defined in terms of capabilities that are declared in a type class.

### **Elegance of use**

Programming is not only about power of expression. 
It is also, and probably even more, about *elegance of use*. 
Traditionally the pointfree style has been considered to be elegant by some programmers and *abstruse* by other programmers. 
Luckily, the `Dotty` programming language comes to the rescue for the latter ones. 
`Dotty` is a *strongly typed*, *scalable* programming language. 
It is possible to *extend the language* in a *type safe* way at the *library* level with *internal domain specific languages*. 

By using a *domain specific language for the domain of programs*, program description based programming can be done in a very elegant way.

Of course, elegance of use is a highly subjective concept. 

#### **informal explanantion of `factorial`**

Consider, again, the program description of `factorial`

```scala
  val factorial: BigInt >--> BigInt =
    `if`(isZero) {
      one
    } `else` {
      `let` {
        subtractOne >-->
          factorial
      } `in` {
        multiply
      }  
    }
```

Below is an *informal explanation* of the *program fragments* of the `factorial` program description above

 - `isZero` is a program description of type `BigInt >--> Boolean`
   - think of `isZero` as a *predicate* that transforms its argument to yield the result `true` if it is equal to `0` and to yield the result`false` otherwise,
 - `one` is a program description of type `BigInt >--> BigInt`
   - think of `one` as a *constant function* that transforms its argument to yield the result `1`,
 - `subtractOne` is a program description of type `BigInt >--> BigInt`
   - think of `subtractOne` as a function that transforms its argument to yield the result obtained by subtracting `1` from it,
 - `multiply` is a program description of type `(BigInt && BigInt) >--> BigInt`
   - think of `multiply` as a function that transforms its *two* arguments to yield the result obtained by multiplying them.

Note that

  - `isZero`, `one` and `subtractOne` are programs with parameter type `BigInt`: one parameter of type `BigInt`,
  - `multiply` is a program with parameter type `BigInt && BigInt`: two parameters of type `BigInt`.

Below is an *informal explanation* of the *program templates* of the `factorial` program description above

 - `first >--> second`  is part of the `Dotty` program description DSL related to `Composition`
   - think of `first` as a *first* function that transforms an argument and `second`as a *second* function that transforms the result yielded by the first function,
 - `` `let` { constructNewUsingCurrent } `in` { useBothNewAndCurrent } `` is part of the `Dotty` program description DSL related to `Construction`
   - note that `let` and `in` are between *backticks*,
   - think of `constructNew` as a function that *constructs* a *new* value using the *current* one,
   - think of `useBothNewAndCurrent` as a function that uses both the *new* value and the *current* value, 
   - together, the new value and the old current value become the new current value,
 - `` `if`(predicate) { trueCase } `else` { falseCase } `` is part of the `Dotty` program description DSL related to `Condition`
   - note that `if` and `else` are between *backticks*,
   - think of `predicate` as a predicate that tests the current value,
   - if `true`, them function `trueCase` takes over control,
   - if `false`, them function `falseCase` takes over control.

Agreed, at first sight the pointfree `factorial` code above may seem a bit abstruse.
Agreed, we explained the pointfree code above in a pointful way.

Once you get used to
 - ` ... >--> ... `, 
 - `` `if`(...) { ... } `else` { ... } ``,  
 - `` `let` { ... } `in` { ... } ``. 

you will, hopefully, start appreciating the power of expression and elegance of use of pointfree code.


### **`FP` versus `PDBP`**

There is an important difference between `FP` programs and `PDBP` programs. 

 - `FP` programs are `FP` *language* based.
 - `PDBP` programs are `Dotty` *library* based.

Exploiting the *flexibility* that comes with this difference is one of the most important themes of the `PDBP` library.

#### **Heteregeneous versus homogeneous**

 - `FP` is *heterogeneous*,
   -  programs are not objects.
 - `PDBP` is *homogeneous*,
   - in `Dotty`, everything is an oject, in particular programs are objects.

#### **Meaning of programs**

 - in `FP`,
   - programs have *one meaning*.
 - in `PDBP,`
   - programs can have *many meanings*. 

Consider, again, the `factorial` program below.

```scala
  val factorial: BigInt >--> BigInt =
    `if`(isZero) {
      one
    } `else` {
      `let` {
        subtractOne >-->
          factorial
      } `in` {
        multiply
      }  
    }
```

Note that `factorial` is a *recursive* program description.
It can be given both a *stack unsafe* meaning and a *stack safe* meaning.
The stack safe meaning simply uses the *heap* instead of the *stack*.

[AppendixLanguageLevelMeaning](#appendixlanguagelevelmeaning) has demo code where meanings are described at the *language level*.

[AppendixLibraryLevelMeaning](#appendixlibrarylevelmeaning) has demo code where meanings are described at the *library level*.

#### **Extra programming capabilities**

 - in `FP`
   - the amount of forms of the language is fixed.
 - in `PDBP`
   - the type class `trait Program` can be extended.

Extra programming capabilities can be added such as

 - input reading
 - output writing
 - state manipulation
 - failure handling
 - latency handling (using parallelism)
 - control handling (using delimited continuations)
 - ...

#### **I/O**

 - in `FP`
   - input and output are *effectful*, they *execute effects* in an *impure* way.
 - in `PDBP`
   - input and output are *effectfree*, they *describe effects* in an *pure* way. 

Of course, eventually, for being useful at all, application code using `PDBP` may need to execute I/O effects.

 - The meaning of `PDBP` I/O effect descriptions is *pushed to the boundaries of application code*.
 - `FP` I/O effects are executed *in the middle of library code*.

A program description performing I/O can be given both an *effectfree* meaning for *testing* purposes and various *effectful* meanings for different deployment purposes. 

### **Main goal of the `PDBP` library**

The *main goal* of the `PDBP` library is to illustrate that program description based programming using a pointfree style in `Dotty` is 

 - *powerful*
   -  as a library developer you can use the full expressive power of monads,
 - *elegant*
   - as an application developer you can use the elegant `Dotty` DSL syntax,
 - *flexible*
   - as a library developer you can define many meanings,
   - as an application developer you can use many meanings,
 - *extendible*
   - as a library developer you can define extra capabilities by need,
   - as an application developer you can use extra capabilities by need,
 - *pure*
   - as a library developer you can define I/O in a pure way.
   - as an application developer you can use I/O both in a pure and an impure way.

### **Summary**

For some of you this introduction may have touched upon a lot of frightening stuff. 

Here is the good news.

 - For now, you only have to concentrate on
   - power of expression, 
   - elegance of use,
 - The features below come in later
   - flexible meanings
   - extra capabilities
   - pure I/0

Moreover we claim that

 - Pointfree program description based application programming naturally leads to deep insights into the nature of programs since it requires you, as an application developer, to reason at an elegant (and reasonably powerful) level of abstraction. 
 - Pointful computation description based library programming naturally leads to deep insights into the nature of computations since it allows you, as a library developer, to reason at a powerful (and reasonably elegant) level of abstraction.

Hopefully, the statements above sounds exiting to both programmers with and programmers without a background in computer science.

# **Appendices**

## **AppendixFunctionsAndExpressions**

Recall that

 - Pointful programming with computations is, in a way, similar to expression oriented, function application (argument binding) based programming with value level expressions.
 - Pointfree programming with programs is, in a way, similar to function oriented, function composition based programming with function level expressions.

This appendix compares pointful and pointfree programming.

### **BindingOperator**

The `implicit class` below formalizes argument binding

```scala
package demo

object bindingOperator {

  implicit class BindingOperator[Z](z: Z) {

    def bind[Y](`z=>y`: Z => Y) = `z=>y` apply z

  }

}
```

### **Square root of sum of squares**

The *square root of the sum of the squares* of `z` and `y` can be defined as

 - `squareRoot(z * z + y * y)`
   - where the *value level expression* `squareRoot(z * z + y * y)` is pointful, expression oriented and function application based.

It can also be defined as
 - `(squares andThen sum andThen squareRoot) apply (z, y)` or `(z, y)  bind (squares andThen sum andThen squareRoot)` 
   - where the *function level expression* `squares andThen sum andThen squareRoot` is pointfree, function oriented and function composition based.

The code below illustrates, among others, how to go from the former one to the latter ones.

```scala
import scala.math.{sqrt => squareRoot}

import bindingOperator.BindingOperator

object FunctionsAndExpressions {

  val z = 3.0
  val y = 4.0

  type &&[+Z, +Y] = Tuple2[Z, Y]

  def main(args: Array[String]): Unit = {

    val result01: Double = squareRoot(z * z + y * y)

    val square: Double => Double =
      z => z * z

    val result02: Double = squareRoot(square(z) + square(y))

    val sum: Double && Double => Double =
      (z, y) => z + y

    val result03: Double = squareRoot(sum(square(z), square(y)))

    val squares: Double && Double => Double && Double =
      (z, y) => (square(z), square(y))

    val result04: Double = squareRoot(sum(squares(z, y)))
    val result05: Double = (squares andThen sum andThen squareRoot)(z, y)

    val result06: Double = (squares andThen sum andThen squareRoot) apply (z, y)
    val result07: Double = (z, y) bind (squares andThen sum andThen squareRoot)

    val result08: Double = (z, y) bind squares bind sum bind squareRoot

    println(result01)
    println(result02)
    println(result03)
    println(result04)
    println(result05)
    println(result06)
    println(result07)
    println(result08)

  }

}
```

Note that argument binding naturally reads from left to right.

## **AppendixDefiningDescriptions**

### **Descriptions in terms of declared capabilities**

This section describes how *descriptions* can be *defined* in terms of *capabilities* that are *declared* in a *type class*.

```scala
package demo

object DefiningDescriptions {

  trait Description[D[+ _]]

  trait Containing[C[+ _]] extends Description[C] {

    def contain[Z](z: Z): C[Z]

  }

  trait SomeValuesContainedIn[C[+ _]: Containing] {

    val containedZero: C[Int] =
      implicitly.contain(0)

    val containedTrue: C[Boolean] =
      implicitly.contain(true)

  }

}
```

`trait Description` is a *marker* `Dotty` type class. 

`trait Containing` is a `Dotty` type class declaring the capability to *contain a value*.

More precisely

 - `Containing[C[+ _]]` declares `C[+ _]`'s capability, `contain`, to contain a value.

We can already start defining some, agreed, very simple, descriptions in terms of this declared capability

```scala
  trait SomeValuesContainedIn[C[+ _]: Containing] {

    val containedZero: C[Int] =
      implicitly.contain(0)

    val containedTrue: C[Boolean] =
      implicitly.contain(true)

  }
```

The type class `trait SomeValuesContainedIn[C[+ _]: Containing]`, declares `C[+ _]` to *implicitly* have the capability to contain a value. 
It defines descriptions `containedZero` and `containedTrue` using this `implicitly` available capability. 

Think of descriptions as *recipes*

 - Take `0` and apply `contain` to it to make `containedZero`. 
   - Think of it as `0` contained in a, for now, *unknown* kind of, *one element container*.
 - Take `true` and apply `contain` to it to make `containedTrue`.
   - Think of it as `true` contained in a, for now unknown kind of, one element container.
 - ... .

At this moment no definition of the declared capability has been provided yet!

## **AppendixLanguageLevelMeaning**

### **Define declared capabilities**

Let's go ahead and provide a first definition of the declared capability in an `object LanguageLevelMeaning`.

```scala
  case class Box[+Z](unbox: Z)

  implicit object implicitBox extends Containing[Box] {

    override def contain[Z](z: Z): Box[Z] = Box(z)

  }
```

`implicitBox` is an `implicit object` that defines the capability `contain` that is declared in `trait Containing`. 

### **Define declared capabilities revisited**

Let's go ahead and provide a second definition of the declared capability in `object LanguageLevelMeaning`.

```scala
  case class Wrap[+Z](unwrap: Z)

  implicit object implicitWrap extends Containing[Wrap] {

    override def contain[Z](z: Z): Wrap[Z] = Wrap(z)

  }
```

`implicitWrap` is an `implicit object` that defines the capability that is declared in `trait Containing`. 

### **Language level meaning**

So far we have defined `implicit object`'s that define the capabilities that are declared in the `Dotty` type class `trait Containing`.
Think of a them as *language level meanings*

### **Defining descriptions in terms of defined capabilities**

This simply boils down to defining `object someBoxedValues` that depends on `implicit object implicitBox`

```scala
  object someBoxedValues extends SomeValuesContainedIn[Box]()
```

### **Defining descriptions in terms of defined capabilities revisited**

This simply boils down to defining `object someWrappedValues` that depends on `implicit object implicitWrap`

```scala
  object someWrappedValues extends SomeValuesContainedIn[Wrap]()
```

### **Use descriptions**

We can now use boxed values

```scala
  def usingBoxedValues: Unit = {

    import someBoxedValues._

    println(containedZero)
    println(containedTrue)

  }
```

Some boxed values are made available using `import someBoxedValues._`.

This technique, called *dependency injection by* `import`, is used a lot in `Dotty`. 

In particular, for *type classes*, like `trait Containing`, dependency injection in `Dotty` boils down to

 - Defining an appropriate `implicit object`.
 - Doing an appropriate `import` of an `object` that depends on that `implicit object`.

### **Use descriptions revisited**

We can now use wrapped values

```scala
  def usingWrappedValues: Unit = {

    import someWrappedValues._

    println(containedZero)
    println(containedTrue)

  }
```

Again we use dependency injection by `import`.

### **Summary**

The most important takeway is that, once the `import` has been done, the rest of the code 
```scala
    println(containedZero)
    println(containedTrue)
```
is the same for `usingBoxedValues` and `usingWrappedValues`.

In this case we talk about only two lines of code, but, hopefully, you get the point.

## **AppendixLibraryLevelMeaning**

TBD

## **Changes**






