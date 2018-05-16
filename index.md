# **Program Description Based Programming**

## **About me**

I worked as a
 - mathematician (research and education),
 - programmer (research, education and consultancy).
 
I am retired now.

I am having fun with my wife Maritza
  - cycling with our race bicycles (climbing mountains, ...),
  - gardening in our green house (lettuce, cauliflower, tomato, bell pepper, ...).

Below is a link to picture, taken by a friend, of me and my wife, cycling in the French Alps.

[Luc and Maritza](./pictures/LucAndMaritza.JPG)

Below is a link to picture of a radish I picked out of my greenhouse 5 minutes ago.

[Radish](./pictures/Radijs.png)

As a hobby I am having fun
  - programming (bridging the gap between mathematical theory and programming practice).

I hope you enjoy the document below.

All comments are welcome at [ pdbp.blog at gmail.com ].

## **Warning**

First, let me be clear about the following
 - both this document and the library it describes are opiniated.

Second, this document is work in progress
 - major changes are documented in section [Changes](#changes).

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

The `FP` forms are 

 - *Function*
 - *Composition*
 - *Construction*
 - *Condition*
 - *Aggregation*

#### **Templates and fragments**

Think of the first four forms as *program templates* and programs transformed by them as *program fragments*, or *program components*, that can be plugged into them to obtain *composite programs*.

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

### **Objects and values**

In `Dotty`, everything is an object.
From now on, when dealing with `Dotty`, we use *object* and *value* interchangably.

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
Program descriptions are *defined* in terms of *programming capabilities* that are *declared* as *members* (`def`'s or `val`'s) of `trait Program`.

By abuse of notation, we often simply refer to program descriptions as *programs*. 
We hope that this does not lead to any confusion.

Compare this with the famous painting [Ceci n'est pas une pipe](https://en.wikipedia.org/wiki/The_Treachery_of_Images) of [René Magritte](https://en.wikipedia.org/wiki/Ren%C3%A9_Magritte). 

Below is a link to a picture of the painting.

[Ceci n'est pas une pipe](./pictures/pipe.png)

The painting is not a pipe, it is a *description* of a pipe.

`trait Program` exposes a *pointfree* programming API for *application developers*.
All it's capabilities are `public`, the default in `Dotty`.

Below is a `factorial` program written using `trait Program`'s API .

```scala
  lazy val factorial: BigInt >--> BigInt =
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

In a way programs generalize *functions*. 

 - A function transforms *function arguments* to yield a *function result*. 
 - A program also, *somehow*, transforms *program arguments* to yield a *program result*. 

When there is no danger of confusion 
  - we simply write *arguments* and *result*, not mentioning *function* or *program*,
  - we simply say that a function transforms an argument to a result.

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
    // ...
    with Program[[-Z, + Y] => Z => M[Y]]
```
`trait Computation` closely resembles *monads*.

In 1991, Eugenio Moggi described monads in
[*Notions of computation and monads*](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.79.733&rep=rep1&type=pdf).

In 1992, Philip Wadler used monads in `Haskell` in 
[*The essence of functional programming*](http://citeseerx.ist.psu.edu/viewdoc/download;jsessionid=E09A5FD9362F6780675ADF29471B7428?doi=10.1.1.38.9516&rep=rep1&type=pdf).

`trait Computation` is about *computation descriptions*. 
Computation descriptions are defined in terms of *computational capabilities* that are declared as members of `trait Computation`.

By abuse of notation, we often simply refer to computation descriptions as *computations*. 
We hope that this does not lead to any confusion.

`trait Computation` exposes a *pointful* programming API for *library developers*.
All it's capabilities are `private[pdbp]`.

In a way computations generalize *expressions*. 

 - An expression *evaluation* yields an *expression result*. 
 - A computation *execution* also, *somehow*, yields a *computation result*.

When there is no danger of confusion 
  - we simply write *result*, not mentioning *expression* or *computation*,
  - we simply say that a computation has a result.

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

Recall that

 - Monads naturally lead to a pointful programming style. 
 - Arrows naturally lead to a pointfree programming style. 

But

 - Monad based computations can, using [*Kleisli categories*](https://en.wikipedia.org/wiki/Kleisli_category), use a pointfree programming style. 
 - Arrow based programs can, using [*arrow calculus*](http://homepages.inf.ed.ac.uk/slindley/papers/arrow-calculus.pdf), use a pointful programming style.

The `PDBP` library goes for programming monads in a pointfree style using Kleisli categories.

### **Introducing `type Kleisli` for programs**

The `with Program[[-Z, + Y] => Z => M[Y]]` part of `trait Computation`, which states that computations have more power of expression than programs, is a bit verbose.

Using the *type alias* `type Kleisli` below

```scala
package pdbp.types.kleisli

object kleisliProgramType {

  type Kleisli[M[+ _]] = [-Z, + Y] => Z => M[Y]

}
```

`trait Computation` can be defined as follows

```scala
package pdbp.computation

import pdbp.types.kleisli.kleisliProgramType.Kleisli

import pdbp.program.Program

private[pdbp] trait Computation[M[+ _]]
    extends Resulting[M]
    with Binding[M]
    // ...
    with Program[Kleisli[M]]
``` 

A program of type `Kleisli[M]` is referred to as a *Kleisli program*. 

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
  lazy val factorial: BigInt >--> BigInt =
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

Also note that

  - actually, `one` is a *generic* program description of type `Z >--> BigInt` *for all* `Z`

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
   - think of `predicate` as a *predicate* (`Boolean`-valued function) that tests the current value,
   - if `true`, then function `trueCase` takes over control,
   - if `false`, then function `falseCase` takes over control.

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
  lazy val factorial: BigInt >--> BigInt =
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

#### **About meanings (for those who are a bit impatient)**

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

A program description involving I/O can be given 
 - *effectfree* meanings for different *testing* purposes,
 - *effectful* meanings for different *deployment* purposes. 
 -  
Of course, eventually, for being useful at all, application code using `PDBP` may need to execute I/O effects.
 - in `FP`
   - I/O effects are executed *in the middle of library code*.
 - in `PDBP`
   - I/O effects are executed *at the boundaries of application code*.

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
   - as a library developer you can define extra capabilities,
   - as an application developer you can use extra capabilities,
 - *pure*
   - as a library developer you can define I/O in a pure way,
   - as a library tester you can use I/O in a pure way.
   - as an application developer you can use I/O in a impure way.

### **Summary**

For some of you this introduction may have touched upon a lot of frightening stuff. 

Here is the good news.

 - For now, you only have to concentrate on
   - power of expression, 
   - elegance of use.
   - 
 - The features below
   - flexible meanings,
   - extra capabilities,
   - pure I/0,
   
   come in later.

To finish, we claim that

 - Pointfree program description based application programming naturally leads to deep insights into the nature of programs (remember: programs generalize functions). It requires you, as an application developer, to reason at an appropriate elegant (and reasonably powerful) level of abstraction. 
 - Pointful computation description based library programming naturally leads to deep insights into the nature of computations (remember: computations generalize expressions). It allows you, as a library developer, to reason at an appropriate, powerful (and reasonably elegant) level of abstraction.

Hopefully, the statements above sound exiting to both programmers with and programmers without a background in computer science.

## **Explaining `trait Program`**

### **Warning**

From now on this document contains a lot of code. 
When reading it in sequential order, you will often be confronted with code that has not been explained yet. 
Do not worry, the code will be explained in the paragraph immediately below it. 

### **Explaining `trait Program`**

Consider

```scala
package pdbp.program

trait Program[>-->[- _, + _]]
    extends Function[>-->]
    with Composition[>-->]
    with Construction[>-->]
    with Condition[>-->]
    with Aggregation[>-->]
```
where

```scala
trait Function[>-->]

trait Composition[>-->]

trait Construction[>-->]

trait Condition[>-->]

trait Aggregation[>-->]
```

belong to the same `package pdbp.program`.

`trait Program` is a *type class* that will gradually be explained later in this document. 
`trait Program` *declares* the *programming capabilities* of *program descriptions*. 

We often write *program* instead of *program description*.

Note that we were a bit sloppy by not showing `[>-->[- _, + _]]`.

`trait Function`, `trait Composition`, `trait Construction` and `trait Condition` will be explained later in this section. 
`trait Aggregation` will be explained later in this document. 

Note that, again, we were a bit sloppy by not showing `[>-->]`.

The programming capabilities of `Function`, `Composition` and `Construction` correspond to *arrows*. 

A program is an `object` of type `Z >--> Y`, where

 - `>-->` is a *binary type constructor*,
 - `Z` is the *parameter* (or *argument*) type of `>-->`,
 - `Y` is the *return* (or *result*) type of `>-->`.

We use

 - parameter and return if we want to be explicit about being at the delaration (or definition) site.

We use

 - argument and result if we want to be explicit about being at the usage site.

We also use argument and result as a default. 

#### **Variance**

Note that `>-->` is

 - *contravariant* in its argument type,
 - *covariant* in its result type.

[AppendixVariance](#appendixvariance) has demo code that illustrates this.

This *variance* property of `>-->` is related to two *principles* that are known as

 - the [*Liskov Substitution Principle*](https://en.wikipedia.org/wiki/Liskov_substitution_principle) which, roughly speaking, states
   - *impose less*,
   - *provide more*, 
 - the [*Internet Robustness Principle*](https://en.wikipedia.org/wiki/Robustness_principle) which, roughly speaking, states 
   - *be liberal in what you receive*,
   - *be generous in what you send*.

### **Explaining `trait Function`**

Consider

```scala
package pdbp.program

trait Function[>-->[- _, + _]] {

  def function[Z, Y]: (Z => Y) => Z >--> Y

  // ...

}
```

Think of `` function(`z=>y`) `` as a program that is a *pure function* `` `z=>y` ``. 
It is supposed to do nothing else than transforming an argument `z` of type `Z` to a yield a result `` y == `z=>y`(z) `` of type `Y`.

For *generic function names*, we use *mixed alphabetic and symbolic characters within backticks*, like `` `z=>y` `` to, hopefully, improve readability. 
We agree that this is a somewhat unusual naming convention.
We know programers who hate it, we know programmers who love it. 
 
Let's explain the reason of this naming convention with some examples that are special cases of [Theorems for free!](http://homepages.inf.ed.ac.uk/wadler/papers/free/free.dvi), as explained by Philip Wadler.

 - There is really only *one* generic function of type `Z => Z` *for all* `Z` : *identity*. 
   - The name `` `z=>z` ``, hopefully, suggests this function.
 - There is really only *one* generic function of type `(Z && Y) => Z` *for all* `Z` and `Y` : *left projection*. 
   - The name `` `(z&&y)=>z` ``, hopefully, suggests this function.
 - There is really only *one* generic function of type `(Z && Y) => Y` *for all* `Z` and `Y` : *right projection*. 
   - The name `` `(z&&y)=>y` ``, hopefully, suggests this function.
 - There is really only *one* generic function of type `(Z && Y) => Y && Z` *for all* `Z` and `Y` : *swap*. 
   - The name `` `(z&&y)=>y&&z` ``, hopefully, suggests this function. 
 - There is really only *one* generic function of type `(Z => Y && Z) => Y` *for all* `Z` and `Y` : *function application* (or, equivalently, *argument binding*). 
   - The name `` `(z=>y&&z)=>y` ``, hopefully, suggests this function.

We use synonyms like `` `y=>y` ``, `` `x=>x` ``, etc. by need, when types `Y`, `X`, etc. are involved.

We could have used names `identity`, `leftProjection`, `rightProjection` `swap` and `functionApplication`. 
Sometimes you simply run out of meaningful generic names.

By the way, argument binding, equivalent with function application, can be defined using an `implicit class` as follows

```scala
object bindingOperator {

  implicit class BindingOperator[Z](z: Z) {

    def bind[Y](`z=>y`: Z => Y) = `z=>y` apply z

  }

}
``` 

The main benefit of generic backtick names comes when trying to understand the type of expressions.

 - `` `z=>y`(z) `` is a function application expression where, hopefully, it should be clear that it has type `Y`. 
 - `` `z=>y` apply z `` is an equivalent expression where function application is explicit, using `apply`. 
 - `` z bind `z=>y` `` is an equivalent expression where argument binding is explicit, using `bind`. 

Note that argument binding can, conveniently, be read from left to right. 

When dealing with more complex expressions, having nested sub-expressions, the usefulness of generic backtick names becomes even more apparent. 

Consider

```scala
package pdbp.program

import pdbp.utils.functionUtils._

trait Function[>-->[- _, + _]] {

  // ...

  def `z>-->z`[Z]: Z >--> Z =
    function(`z=>z`)  
  
} 
```

We defined `` `z>-->z` `` in terms of `function` and `` `z=>z` `` where 

  - `` `z=>z` `` 

is the function you expect.

The function is defined below

```scala
package pdbp.utils

object functionUtils {

  def `z=>z`[Z]: Z => Z = { z =>
    z
  }

  // ...

} 
```

For programs, we use generic backtick names like `` `z>-->y` `` to, hopefully, improve readability. 

You may have doubts about the usefulness of a trivial program like`` `z>-->z` ``.  
It turns out that, when defining more complex composite programs, obtained by plugging program components, into program templates, replacing one or more of the components, by `` `z>-->z` `` results in interesting programs of their own.

In what follows we also refer to programs `` function(`z=>y`) `` as *atomic program fragments*. 
In `PDBP` pure functions are atomic program building blocks. 
It is up to you to define the *complexity* of the functions `` `z=>y` ``.

For example, `factorial` might as wel have been defined as follows

```scala
package demo

import pdbp.types.product.productType._

object FactorialFunction {

  val factorialFunction: BigInt => BigInt = { i =>
    if (isZeroFunction(i)) {
      oneFunction(i)
    } else {
      val subtractOneAndThenFactorial =
        subtractOneFunction andThen factorialFunction
      multiplyFunction(i, subtractOneAndThenFactorial(i))
    }
  }

  // ...

}

import pdbp.program.Function

import FactorialFunction._

class FactorialAsFunction[>-->[- _, + _]: Function] {

  import implicitly._

  val factorial: BigInt >--> BigInt = function(factorialFunction)

} 

```  

where

```scala
  val isZeroFunction: BigInt => Boolean = { i =>
    i == 0
  }

  def oneFunction[Z]: Z => BigInt = { z =>
    1
  }

  val multiplyFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
    i * j
  }

  val subtractOneFunction: BigInt => BigInt = { i =>
    i - 1
  }

}
```

If we define the program description `factorial` as `function(factorialFunction)`,
then we have less flexibility for giving a meaning to it.

### **Explaining `trait Composition`**

Consider

```scala
package pdbp.program

trait Composition[>-->[- _, + _]] {

  def compose[Z, Y, X](`z>-->y`: Z >--> Y, `y>-->x`: => Y >--> X): Z >--> X

}
```
Think of `compose` as a *program template* and of `` `z>-->y` `` and `` `y>-->x` `` as *program fragments*.

Translated to functions:

Think of `compose` as a *function template* (a.k.a. *higher order function*) and of `` `z>-->y` `` and `` `y>-->x` `` as *function fragments* (a.k.a. *function arguments*).

`` composition(`z>-->y`, `y>-->x`) `` is the *sequential composition* of `` `z>-->y` `` and `` `y>-->x` ``. 

If the program `` `z>-->y` `` transforms an argument of type `Z` to yield a result of type `Y`, 
then that result serves as an argument for the *subsequent* program `` `y>-->x` `` which transforms it to yield a result of type `X`.

Note that `` `y>-->x` `` is a *call-by-name parameter*.
If program `` `z>-->y` `` fails to yield a result, then program `` `y>-->x` `` is not used.  

Consider

```scala
object compositionOperator {

  implicit class CompositionOperator[>-->[- _, + _]: Composition, -Z, +Y](
      `z>-->y`: Z >--> Y) {

    import implicitly._    

    def >-->[X](`y>-->x`: => Y >--> X) = {
      compose(`z>-->y`, `y>-->x`)
    }

  }

}
```

  - `compose` comes with an *operator* equivalent `>-->`. 

The type constructor `>-->` is declared to implicitly have the programming capability `compose` that is declared in the type class `trait Composition`. The operator `>-->` is defined in terms of this declared programming capability. The definition uses `implicitly`, an abbreviation for `implicitly[Composition[>-->]]`, that is available as an *implicit evidence* having the `compose` capability of `Composition`.

`` /* ... */ >--> /* ... */ `` is a first example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor. 

It should not come as a surprise that 
  - `` `z>-->y` >--> `y>-->x` `` has type `Z >--> X`.

### **Explaining `trait Construction`**

Consider

```scala
package pdbp.program

import pdbp.types.product.productType._

trait Construction[>-->[- _, + _]] {
  this: Function[>-->] & Composition[>-->] =>

  def product[Z, Y, X](`z>-->y`: Z >--> Y,
                       `z>-->x`: => Z >--> X): Z >--> (Y && X) =
    product(`z>-->y`, `z>-->x`, `(y&&x)>-->(y&&x)`)

  def product[Z, Y, X, W](`z>-->y`: Z >--> Y,
                          `z>-->x`: => Z >--> X,
                          `(y&&x)>-->w`: => (Y && X) >--> W): Z >--> W =
    compose(product(`z>-->y`, `z>-->x`), `(y&&x)>-->w`)

  def and[Z, X, Y, W](`z>-->x`: Z >--> X,
                      `y>-->w`: => Y >--> W): (Z && Y) >--> (X && W) =
    product(compose(`(z&&y)>-->z`, `z>-->x`), compose(`(z&&y)>-->y`, `y>-->w`))

  def `let`[Z, Y, X](`z>-->y`: Z >--> Y): In[Z, Y, X] =
    new In[Z, Y, X] {
      def `in`(`(z&&y)>-->x`: => (Z && Y) >--> X): Z >--> X =
        compose(product(`z>-->z`, `z>-->y`), `(z&&y)>-->x`)
    }

  trait In[Z, Y, X] {
    def `in`(`(z&&y)>-->x`: => (Z && Y) >--> X): Z >--> X
  }

}
```

where

```scala
package pdbp.types.product

object productType {

  type &&[+Z, +Y] = Tuple2[Z, Y]
  
}
```

and where

 - `` `(y&&x)>-->(y&&x)` ``,
 - `` `(z&&y)>-->z` ``, 
 - `` `(z&&y)>-->y` ``

are the programs you expect.

The programs are defined below

```scala
package pdbp.program

import pdbp.types.product.productType._

// ...
import pdbp.utils.productUtils._

trait Function[>-->[- _, + _]] {

  // ...

  def `(y&&x)>-->(y&&x)`[Y, X]: (Y && X) >--> (Y && X) =
    function(`(y&&x)=>(y&&x)`)

  def `(z&&y)>-->z`[Z, Y]: (Z && Y) >--> Z =
    function(`(z&&y)=>z`)

  def `(z&&y)>-->y`[Z, Y]: (Z && Y) >--> Y =
    function(`(z&&y)=>y`)

}
```

where

```scala
package pdbp.utils

import pdbp.types.product.productType._

object productUtils {

  def `(y&&x)=>(y&&x)`[Y, X]: (Y && X) => (Y && X) = { `y&&x` =>
    `y&&x`
  }

  def `(z&&y)=>z`[Z, Y]: (Z && Y) => Z = { (z, _) =>
    z
  }

  def `(z&&y)=>y`[Z, Y]: (Z && Y) => Y = { (_, y) =>
    y
  }

  // ...

}
```

Think of `product` as a program template and of `` `z>-->y` `` and `` `z>-->x` `` as program fragments.

`` product(`z>-->y`, `z>-->x`) `` *constructs* a result from the results of `` `z>-->y` `` and `` `z>-->x` ``.

If the program `` `z>-->y` `` transforms an argument of type `Z` to yield a result of type `Y`, 
and the program `` `z>-->y` `` transforms that argument to yield a result of type `Y`,
then the program `` product(`z>-->y`, `z>-->x`) `` transforms that argument to yield a result of type `Y && X`.

#### **Many arguments resp. results**

Programs are objects of type `Z >--> Y`.

It may look as if programs can have only *one* argument resp. result.

Think of one object of type `Y && X` as two objects, more precisely, both an object of type `Y` and an object of type `X`. This is the way the `PDBP` library deals with *two* arguments resp. results.

The `PDBP` library deals with *many* arguments resp. results using *nested tuples*

  - `Z && Y` for two of them,
  - `Z && (Y && X)` for three of them,
  - `Z && (Y && (X && W)` for four of them,
  - ...  

### **Explaining `trait Construction` continued**

`trait Construction` has three other members

 - `product[Z, Y, X, W]` is a more complex version of `product[Z, Y, X]`,
 - `and[Z, Y, X, W]` is yet another more complex version of `product[Z, Y, X]`,
 - `` `let`[Z, Y, X] `` has a parameter that is a program that *constructs a new result*, and `` `in` `` has a parameter that is a program that has that result available as an *extra argument*.

Note that

 - `product[Z, Y, X]` can be defined in terms of `product[Z, Y, X, W]` and `` `(y&&x)>-->(y&&x)` ``,
 - `product[Z, Y, X, W]` can be defined in terms of `product[Z, Y, X]` and `compose`,
 - `and[Z, Y, X, W]` can be defined in terms of `product[Z, Y, X]`, `` `(z&&y)>-->z` ``, `` `(z&&y)>-->y` `` and `compose`,
 - `` `let`[Z, Y, X] `` and `` `in` `` can be defined in terms of `product`, `` `z>-->z` `` and `compose`.

Note that the definitions are *left biased*. Their first parameter is a by-value parameter. Their second parameter is a by-name parameter. 

`` `let` { /* ... */ } `in` { /* ... */ } `` is a second example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor.

Consider

```scala
object constructionOperators {

  implicit class ConstructionOperators[>-->[- _, + _]: Construction, -Z, +Y](
      `z>-->y`: Z >--> Y) {

    import implicitly._   

    def &[ZZ <: Z, X](`zz>-->x`: => ZZ >--> X) =
      product(`z>-->y`, `zz>-->x`)

    def &&[X, W](`x>-->w`: => X >--> W) =
      and(`z>-->y`, `x>-->w`)

  }

}
```

  - `product[Z, Y, X]` comes with an operator equivalent `&`,
  - `and[Z, Y, X, W]` comes with an operator equivalent `&&`.

The type constructor `>-->` is declared to implicitly have the programming capabilities `product` and `and` that are declared in the type class `trait Construction`. The operators `&` and `&&` are defined in terms of those declared programming capabilities. The definitions use `implicitly`, an abbreviation for `implicitly[Construction[>-->]]`, that is available as an implicit evidence having the `product` and `and` capabilities of `Construction`.

`` /* ... */ & /* ... */ `` and `` /* ... */ && /* ... */ `` are a third and fourth example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor. 

It should not come as a surprise that 
  - `` `z>-->y` & `z>-->x` `` has type `Z >--> (Y && X)`,
  - `` `z>-->y` && `x>-->w` `` has type `(Z && X) >--> (Y && W)`.

### **Explaining `trait Condition`**

Consider 

```scala
package pdbp.program

import pdbp.types.product.productType._
import pdbp.types.sum.sumType._

import pdbp.utils.productUtils._
import pdbp.utils.sumUtils._

trait Condition[>-->[- _, + _]] {
  this: Function[>-->] & Composition[>-->] & Construction[>-->] =>

  def sum[Z, Y, X](`y>-->z`: => Y >--> Z,
                   `x>-->z`: => X >--> Z): (Y || X) >--> Z =
    sum(`(y||x)>-->(y||x)`, `y>-->z`, `x>-->z`)

  def sum[Z, Y, X, W](`w>-->(y||x)`: W >--> (Y || X),
                      `y>-->z`: => Y >--> Z,
                      `x>-->z`: => X >--> Z): W >--> Z =
    compose(`w>-->(y||x)`, sum(`y>-->z`, `x>-->z`))

  def or[Z, X, Y, W](`x>-->z`: => X >--> Z,
                     `w>-->y`: => W >--> Y): (X || W) >--> (Z || Y) =
    sum(compose(`x>-->z`, `z>-->(z||y)`), compose(`w>-->y`, `y>-->(z||y)`))

  def `if`[W, Z](`w>-->b`: W >--> Boolean): Apply[W, Z] =
    new Apply[W, Z] {
      override def apply(`w>-t->z`: => W >--> Z): Else[W, Z] =
        new Else[W, Z] {
          override def `else`(`w>-f->z`: => W >--> Z): W >--> Z =
            sum(`let`(`w>-->b`) `in` `(w&&b)>-->(w||w)`, `w>-t->z`, `w>-f->z`)
        }
    }

  trait Apply[W, Z] {
    def apply(`w>-t->z`: => W >--> Z): Else[W, Z]
  }

  trait Else[W, Z] {
    def `else`(`w>-f->z`: => W >--> Z): W >--> Z
  }

}
```
where

```scala
package pdbp.types.sum

object sumType {

  case class Left[+Z](z: Z)

  case class Right[+Y](y: Y)

  type ||[+Z, +Y] = Left[Z] | Right[Y]

}
```

and where

 - `` `(y||x)>-->(y||x)` ``,
 - `` `z>-->(z||y)` ``,
 - `` `y>-->(z||y)` ``,
 - `` `(w&&b)>-->(w||w)` ``, where `b` corresponds to the type `Boolean`

are the programs you expect. 

Agreed, `` `(w&&b)>-->(w||w)` `` is actually one of the two programs you expect. It is the one where `true` corresponds to `Left` and  `false` corresponds to `Right`.

The programs are defined below

```scala
package pdbp.program

// ...
import pdbp.types.sum.sumType._

// ...
import pdbp.utils.sumUtils._
import pdbp.utils.productAndSumUtils._

trait Function[>-->[- _, + _]] {

  // ...

  def `(y||x)>-->(y||x)`[Y, X]: (Y || X) >--> (Y || X) =
    function(`(y||x)=>(y||x)`)

  def `z>-->(z||y)`[Z, Y]: Z >--> (Z || Y) =
    function(`z=>(z||y)`)

  def `y>-->(z||y)`[Z, Y]: Y >--> (Z || Y) =
    function(`y=>(z||y)`)

  def `(w&&b)>-->(w||w)`[W]: (W && Boolean) >--> (W || W) =
    function(`(w&&b)=>(w||w)`)

}
```

where

```scala
package pdbp.utils

import pdbp.types.sum.sumType._

object sumUtils {

  def `(y||x)=>(y||x)`[Y, X]: (Y || X) => (Y || X) = { `y||x` =>
    `y||x`
  }

  def `z=>(z||y)`[Z, Y]: Z => (Z || Y) = { z =>
    Left(z)
  }

  def `y=>(z||y)`[Z, Y]: Y => (Z || Y) = { y =>
    Right(y)
  }

  // ...

}
```

and where

```scala
package pdbp.utils

import pdbp.types.product.productType._
import pdbp.types.sum.sumType._

object productAndSumUtils {

  def foldBoolean[Z](tz: => Z, fz: => Z): Boolean => Z = {
    case true  => tz
    case false => fz
  }

  def `(w&&b)=>(w||w)`[W]: (W && Boolean) => (W || W) = { (w, b) =>
    foldBoolean[W || W](Left(w), Right(w))(b)
  }

  // ...

}
```

Think of `sum` as a program template and of `` `y>-->z` `` and `` `x>-->z` `` as program fragments.

`` sum(`y>-->z`, `x>-->z`) `` uses a *"left or right" condition* to behave either as `` `y>-->z` `` or as `` `x>-->z` ``.

### **Explaining `trait Condition` continued**

`trait Condition` has three other members

 - `sum[Z, Y, X, W]` is a more complex version of `sum[Z, Y, X]`,
 - `or[Z, X, Y, W]` is yet another more complex version of `sum[Z, Y, X]`,
 - `` `if`[W, Z] `` has a parameter that is a program that has a result of type `Boolean` that is used to behave either as the parameter of `apply` or as the parameter of `` `else` ``.

Note that

 - `sum[Z, Y, X]` can be defined in terms of `sum[Z, Y, X, W]` and `` `(y||x)>-->(y||x)` ``,
 - `sum[Z, Y, X, W]` can be defined in terms of `sum[Z, Y, X]` and `compose`,
 - `and[Z, Y, X, W]` can be defined in terms of `product[Z, Y, X]`, `` `(z&&y)>-->z` ``, `` `(z&&y)>-->y` `` and `compose`,
 - `` `if`[W, Z] `` and `` `else` `` can be defined in terms of `sum`, `` `let` `` and `` `in` ``.

`` `if`(/* ... */) { /* ... */ } `else` { /* ... */ } `` is a fifth example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor. 

#### **about the power of expression of `` `let` { ... } `in` { ... } ``**

`product[Z, Y, X]` can be defined in terms of `` `let` { ... } `in` { ... } ``.

```scala
package demo

import pdbp.types.product.productType._

import pdbp.utils.productUtils._

import pdbp.program.Function
import pdbp.program.Composition
import pdbp.program.Construction

import pdbp.program.compositionOperator._

trait ProductInTermsOfLetAndIn[
    >-->[- _, + _]: Function: Composition: Construction] {

  val implicitFunction = implicitly[Function[>-->]]
  val implicitConstruction = implicitly[Construction[>-->]]

  import implicitFunction._
  import implicitConstruction._

  def product[Z, Y, X](`z>-->y`: Z >--> Y,
                       `z>-->x`: => Z >--> X): Z >--> (Y && X) =
    `let` {
      `z>-->y`
    } `in` {
      `let` {
        `(z&&y)>-->z` >--> `z>-->x`
      } `in` {
        `(z&&y&&x)>-->(y&&x)`
      }
    }

}
```
where

  - `` `(z&&y&&x)>-->(y&&x)` `` 
 
is the program you expect.

The program is defined below

```scala
package pdbp.program

// ...

trait Function[>-->[- _, + _]] {

  // ...

  def `(z&&y&&x)>-->(y&&x)`[Z, Y, X]: (Z && Y && X) >--> (Y && X) =
    function(`(z&&y&&x)=>(y&&x)`)    

  // ...

}
```

where

```scala
package pdbp.utils

// ...

object productUtils {

  // ...

  def `(z&&y&&x)=>(y&&x)`[Z, Y, X]: (Z && Y && X) => (Y && X) = {
    case ((_, y), x) => (y, x)
  }

}
```

The definition of `product` is an example of a recurring theme of the `PDBP` library: defining a program description, or programming capability, often boils down to a *getting the types right puzzle*. Often there is only one meaningful way to get them right. Let's have a look at some of the details of the puzzle for this definition`.

The outer `` `let` `` creates, using `` `z>-->y` ``, a new argument of type `Y` for the outer `` `in` `` which, as a consequence, has an argument of type `Z && Y` available, representing two arguments, one of type `Z` and one of type `Y`. The main difference between `` `let` `` and `compose` is that `` `let` `` does *not* loose the original argument of type `Z`. 

The inner `` `let` `` of the outer `` `in` `` creates, using `` `(z&&y)>-->z` >--> `z>-->x` ``, the composition of `` `(z&&y)>-->z` `` and `` `z>-->x` ``, a new argument of type `X` for the inner `` `in` ``  of the outer `` `in` `` which, as a consequence, has an argument of type `Z && Y && X` available, representing three arguments, one of type `Z`, one of type `Y`, and one of type `X`. 

The inner `` `in` `` in the outer `` `in` `` simply gets rid of the original argument of type `Z` using `` `(z&&y&&x)>-->(y&&x)` ``.

Note that generic backtick names, hopefully, help to understand the puzzle. 
For example

  - in the composition `` `(z&&y)>-->z` >--> `z>-->x` ``, the matching `z`'s reflect the type `Z` involved,
  - in the name `` `(z&&y&&x)>-->(y&&x)` ``, both `(z&&y&&x)` and `(y&&x)` reflect the types `(Z && Y && X)` and `(Y && X)` involved. 

#### **about the power of expression of `` `if`(...) { ... } `else` { ... }``**

`sum[Z, Y, X]` can be defined in terms of `` `if`(...) { ... } `else` { ... }``.

```scala
package demo

import pdbp.types.sum.sumType._

import pdbp.utils.sumUtils._

import pdbp.program.Function
import pdbp.program.Composition
import pdbp.program.Condition

import pdbp.program.compositionOperator._

trait SumInTermsOfIfAndElse[>-->[- _, + _]: Function: Composition: Condition] {
  val implicitFunction = implicitly[Function[>-->]]
  val implicitCondition = implicitly[Condition[>-->]]

  import implicitFunction._
  import implicitCondition._

  def sum[Z, Y, X](`y>-->z`: => Y >--> Z,
                   `x>-->z`: => X >--> Z): (Y || X) >--> Z =
    `if`(`(y||x)>-->b`) {
      `(y||x)>-->y` >--> `y>-->z`
    } `else` {
      `(y||x)>-->x` >--> `x>-->z`
    }

}
```

where

  - `` `(y||x)>-->y` ``,
  - `` `(y||x)>-->x` ``,
  - `` `(y||x)>-->b` ``, where `b` corresponds to the type `Boolean`
 
are the programs you expect.

Agreed, `` `(y||x)>-->b` `` is actually one of the two programs you expect. It is the one where `true` corresponds to `Left` and  `false` corresponds to `Right`.

The programs are defined below

```scala
package pdbp.utils

// ...

object sumUtils {

  // ...

  def foldSum[Z, Y, X](`y=>z`: => Y => Z, `x=>z`: => X => Z): (Y || X) => Z = {
    case Left(y) =>
      `y=>z`(y)
    case Right(x) =>
      `x=>z`(x)
  }

  def `(y||x)=>b`[Y, X]: (Y || X) => Boolean =
    foldSum[Boolean, Y, X](_ => true, _ => false)

  def `(y||x)=>y`[Y, X]: (Y || X) => Y =
    foldSum[Y, Y, X](y => y, _ => ???)

  def `(y||x)=>x`[Y, X]: (Y || X) => X =
    foldSum[X, Y, X](_ => ???, x => x)  

}
```

where

```scala
package pdbp.program

// ...

trait Function[>-->[- _, + _]] {

  // ...

  def `(y||x)>-->y`[Y, X]: (Y || X) >--> Y =
    function(`(y||x)=>y`)

  def `(y||x)>-->x`[Y, X]: (Y || X) >--> X =
    function(`(y||x)=>x`)    

  def `(y||x)>-->b`[Y, X]: (Y || X) >--> Boolean =
    function(`(y||x)=>b`)

  // ...

}
```

Note that, again, generic backtick names, hopefully, help to understand the puzzle. 
For example

  - in the composition `` `(y||x)>-->y` >--> `y>-->z` ``, the matching `y`'s reflect the type `Y` involved, 
  - In the composition `` `(y||x)>-->x` >--> `x>-->z` ``, the matching `x`'s reflect the type `X` involved.

#### **Pointfree programming challenge**

One challenge that comes with pointfree programming is getting the *necessary arguments* out of *all arguments*. 
One way to deal with this challenge is to keep programs, and therefore, the arguments that come with them, relatively small. 

After all, small program fragments can be combined to obtain larger ones by plugging them into program templates.

[*Erik Meijer*](https://en.wikipedia.org/wiki/Erik_Meijer_(computer_scientist)) refers to this programming paradigm in a somewhat funny way as *good programmers write baby-code.* 
Erik Meijer is so famous that he does not need an introduction. 
I was very lucky to be able to do research with him, on monads and related stuff, at the Univeristy of Utrecht back in the ninetees.

#### **formal top-down explanantion of `factorial`**
  
Below is a *formal top-down explanation* of the `factorial` program description using the programming capabilities defined so far.

```scala
package demo

import pdbp.types.product.productType._

import pdbp.utils.productUtils._

import pdbp.program.Program
import pdbp.program.compositionOperator._

class FactorialTopDown[>-->[- _, + _]: Program] {

  import implicitly._

  val factorial: BigInt >--> BigInt =
    `if`(isZero) {
      one
    } `else` {
      factorialOfNonZero
    }

  // ...  
```

`factorial` above uses 

  - the `` `if`(...) { ... } `else` { ... } `` program template capability of `trait Condition`.
  - the atomic program fragment `isZero`
  - the atomic program fragment `one`
  - the composite program fragment `factorialOfNonZero`

where

```scala
  val isZero: BigInt >--> Boolean =
    function(isZeroFunction)

  val isZeroFunction: BigInt => Boolean = { i =>
    i == 0
  }

  def one[Z]: Z >--> BigInt =
    function(oneFunction)

  def oneFunction[Z]: Z => BigInt = { z =>
    1
  }
```

and

```scala
  val factorialOfNonZero: BigInt >--> BigInt =
    `let` {
      subtractOneAndThenFactorial
    } `in` {
      multiply
    }  
```

`factorialOfNonZero` above uses 

  - the `` `let` { ... } `in` { ... } `` program template capability of `trait Construction`.
  - the atomic program fragment `multiply`
  - the composite program fragment `subtractOneAndThenFactorial`

where

```scala
  val multiply: (BigInt && BigInt) >--> BigInt =
    function(multiplyFunction)

  val multiplyFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
    i * j
  }    
```

and

```scala
  val subtractOneAndThenFactorial: BigInt >--> BigInt =
    subtractOne >-->
      factorial    
```

`subtractOneAndThenFactorial` above uses 

  - the `>-->` program template capability of `trait Composition` (more precisely, of `implicit class CompositionOperator`).
  - the atomic program fragment `subtractOne`
  - *recursively*, `factorial` *itself* as a program fragment

where

```scala
  val subtractOne: BigInt >--> BigInt =
    function(subtractOneFunction)

  val subtractOneFunction: BigInt => BigInt = { i =>
    i - 1
  }   
```

### **`factorial` revisited**

Below is, again, the code of `factorial`

```scala
package examples.programs

import pdbp.types.product.productType._

import pdbp.program.Program

import pdbp.program.compositionOperator._

import examples.utils.functionUtils._

class Factorial[>-->[- _, + _]: Program] {

  import implicitly._

  import examples._

  private[programs] lazy val factorial: BigInt >--> BigInt =
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

  private[programs] val isZero: BigInt >--> Boolean =
    function(isZeroFunction)

  private[programs] val subtractOne: BigInt >--> BigInt =
    function(subtractOneFunction)

  private[programs] val multiply: (BigInt && BigInt) >--> BigInt =
    function(multiplyFunction)

  private[programs] def one[Z]: Z >--> BigInt =
    function(oneFunction)

  // ...  
    
}
```

### **main programs**

Recall that programs have type `Z >--> Y` for types `Z` and `Y`.

For example: `factorial` above has type `BigInt >--> BigInt`.

A *main program* has type `Unit >--> Unit`.

If

 - `producer` is a *producer program* of type `Unit >--> Z`,
 - `program` is a *program* of type `Z >--> Y`,
 - `consumer` is a *consumer program* of type `Y >--> Unit`,
 - 
then rogram

 - `producer >--> program >--> consumer` is a main program.

We also simply refer to 

  - a producer program as a *producer*,
  - a consumer program as a *consumer*.

### **`factorialMain` using an effectful producer and consumer**

Consider

```scala
package examples.programs

// ...
import pdbp.utils.effectfulUtils._
// ...

class Factorial[>-->[- _, + _]: Program] {

  // ...

  private[programs] def effectfulReadIntFromConsole(message: String): Unit >--> BigInt =
    function(effectfulReadIntFromConsoleFunction(message))

  private[programs] def effectfulWriteToConsole[Y](message: String): Y >--> Unit =
    function(effectfulWriteToConsoleFunction(message))

  private[programs] val producer: Unit >--> BigInt =
    effectfulReadIntFromConsole("please type an integer")

  private[programs] val consumer: BigInt >--> Unit =
    effectfulWriteToConsole("the factorial value of the integer is")

  val factorialMain: Unit >--> Unit =
    producer >-->
      factorial >-->
      consumer

}
```

where

```scala
package pdbp.utils

import scala.io.StdIn.readInt

object effectfulUtils {

  def effectfulReadIntFromConsoleFunction(message: String): Unit => BigInt = { _ =>
    println(s"$message")
    val i = BigInt(readInt())
    i
  }

  def effectfulWriteToConsoleFunction[Y](message: String): Y => Unit = { y =>
    println(s"$message")
    val u = println(s"$y")
    u
  }

}
```

Both the producer and consumer above are *effectful*.
They *execute effects* in an *impure* way.

  - the function `effectfulReadIntFromConsoleFunction` that is used by `effectfulReadIntFromConsole` is not pure 
    - it executes the `println("message")` and `readInt()` effects in an impure way
  - the function `effectfulWriteToConsoleFunction` that is used by `effectfulWriteToConsole` is not pure
    - it executes the `println("message")` and `println(s"$y")` effects in an impure way

Using the the producer and consumer above we can now define `factorialMain`

```scala
package examples.programs

// ...

class Factorial[>-->[- _, + _]: Program] {

  // ...

  val factorialMain: Unit >--> Unit =
    producer >-->
      factorial >-->
      consumer

}
```

Note that `effectfulReadIntFromConsole` resp. `effectfulWriteToConsole` should (and will) be replaced by an *effectfree* producer resp. consumer that *describes effects* in an *pure* way rather than executing them in an impure way.

## **Explaining `trait Computation`**

### **Explaining `trait Computation`**

Consider

```scala
package pdbp.computation

import pdbp.types.kleisli.kleisliProgramType.Kleisli

import pdbp.program.Program

private[pdbp] trait Computation[M[+ _]]
    extends Resulting[M]
    with Binding[M]
    with Lifting[M]
    with Sequencing[M]
    with Program[Kleisli[M]]
```

where

```scala
private[pdbp] trait Resulting[M]

private[pdbp] trait Binding[M]

private[pdbp] trait Lifting[M]

private[pdbp] trait Sequencing[M]
```

belong to the same `package pdbp.computation`.

`trait Computation` is a *type class* that will gradually be explained later in this section. 
`trait Computation` *declares* the *computational capabilities* of *computation descriptions*. 

We often write *computation* instead of *computation description*.

Note that we were a bit sloppy by not showing `[M[+ _]]`.

`trait Resulting`, `trait Binding` and `trait Lifting` will be explained later in this section. 
`trait Sequencing` will be explained later in this document. 

Note that, again, we were a bit sloppy by not showing `[M]`.

The computational capabilities of `Resulting` and `Binding` correspond to *monads*. 

A computation is an `object` of type `M[Z]`, where

 - `M` is a *unary type constructor*,
 - `Z` is the *return* (or *result*) type of `M`.

We use

 - return if we want to be explicit about being at the delaration (or definition) site.

We use

 - result if we want to be explicit about being at the usage site.

We also use result as a default. 

#### **`PDBP` library users versus `PDBP` library developers**

Note that all computational capabilities are defined as `private [pdbp]`. 

We do not want to expose pointful capabilies to the *users* of the `PDBP` library. 
We only expose pointfree capabilities to the users of the `PDBP` library. 
It is convenient to have pointful capabilies available for the *developers* of the `PDBP` library. 
It is also *simpler* (not necessarily *easier*, though) to define `Computation` instances since `Computation` has less undefined declared capabilities than `Program`.

#### **Variance**

Note that `M` is

 - *covariant* in its result type.

This *variance* property of `M` is related to two principles that are known as

 - the [*Liskov Substitution Principle*](https://en.wikipedia.org/wiki/Liskov_substitution_principle) which, roughly speaking, states, among others
   - *provide more*, 
 - the [*Internet Robustness Principle*](https://en.wikipedia.org/wiki/Robustness_principle) which, roughly speaking, states, among others 
   - *be generous in what you send*.

### **Explaining `trait Resulting`**

Consider

```scala
package pdbp.computation

private[pdbp] trait Resulting[M[+ _]] {

  private[pdbp] def result[Z]: Z => M[Z]

}
```

Think of `result(ez)` as a computation that is a *pure expression* `ez`. 
*Executing* `result(ez)` is supposed to do nothing else than *evaluating* the expression `ez` to a yield a result of type `Z`.

### **Explaining `trait Binding`**

Consider

```scala
package pdbp.computation

private[pdbp] trait Binding[M[+ _]] {

  private[pdbp] def bind[Z, Y](mz: M[Z], `z=>my`: => Z => M[Y]): M[Y]

}
```

Think of `` `z=>my` `` as a *computation execution continuation template* or simply, *computation template* and of `mz` as a *computation fragment* (a.k.a. *sub-computation*).

Translated to expressions:

Think of `` `z=>my` `` as an *expression evaluation continuation template*, or simply, *expression template* and of `mz` as an *expression fragment* (a.k.a. *sub-expression*).

`` bind(mz, `z=>my`) `` is function that *binds* `mz` to `z=>my`.

If the computation `mz` yields a result of type Z, then that result serves as an argument for the subsequent function `z=>my` which transforms it to a computation that yields a result of type Y.

In what follows we also refer to computations `result(ez)` as *atomic computation fragments*. 
In `PDBP` pure expressions are atomic computation building blocks. 
It is up to you to define the *complexity* of the expressions `ez`.

### **Explaining `trait Lifting`**

Consider

```scala
package pdbp.computation

private[pdbp] trait Lifting[M[+ _]]
    extends ObjectLifting[M]
    with FunctionLifting[M]
    with OperatorLifting[M]
```

where

```scala
private[pdbp] trait ObjectLifting[M]

private[pdbp] trait FunctionLifting[M]

private[pdbp] trait OperatorLifting[M]
```

belong to the same `package pdbp.computation`.

`trait Lifting` is a type class that will gradually be explained later in this section. 
`trait Lifting` declares the *lifting capabilities* of computation descriptions. 

Note that we were a bit sloppy by not showing `[M[+ _]]`.

The lifting capabilities of `Lifting` correspond to *applicatives* (a.k.a. *idioms*).

`trait ObjectLifting`, `trait FunctionLifting` and `trait OperatorLifting` will be explained later in this section. 

Note that, again, we were a bit sloppy by not showing `[M]`.

#### **Explaining `trait ObjectLifting`**

Consider

```scala
package pdbp.computation

private[pdbp] trait ObjectLifting[M[+ _]] {

  private[pdbp] def liftObject[Z](z: Z): M[Z]

}
```

`liftObject` is a function that *lifts* an *object* `z` to a *computation* with result `z`.

#### **Explaining `trait FunctionLifting`**

Consider

```scala
package pdbp.computation

private[pdbp] trait FunctionLifting[M[+ _]] {

  private[pdbp] def liftFunction[Z, Y](`z=>y`: Z => Y): M[Z] => M[Y]

}
```

`liftFunction` is a function that *lifts* an *object-level function* to a *computation-level function*.

#### **Explaining `trait OperatorLifting`**

Consider

```scala
import pdbp.types.product.productType._

private[pdbp] trait OperatorLifting[M[+ _]] {

  private[pdbp] def liftOperator[Z, Y, X](
      `(z&&y)=>x`: (Z && Y) => X): (M[Z] && M[Y]) => M[X]
}
```

`liftOperator` is a function that *lifts* an *object-level operator* to a *computation-level operator*.

### **Explaining `trait Lifting` revisited**

Consider

```scala
package pdbp.computation

import pdbp.types.product.productType._

import pdbp.utils.productUtils._

private[pdbp] trait Lifting[M[+ _]]
    extends ObjectLifting[M]
    with FunctionLifting[M]
    with OperatorLifting[M] {

  private[pdbp] def liftedAnd[Z, Y]: (M[Z] && M[Y]) => M[Z && Y] =
    liftOperator(`(z&&y)=>(z&&y)`)

  private[pdbp] def liftedApply[Z, Y]: (M[Z => Y] && M[Z]) => M[Y] =
    liftOperator(`((z=>y)&&z)=>y`)

  private[pdbp] override def liftFunction[Z, Y](`z=>y`: Z => Y): M[Z] => M[Y] =
    liftedApply(liftObject(`z=>y`), _)

  private[pdbp] def lift0[Z](z: Z) =
    liftObject(z)

  private[pdbp] def lift1[Z, Y](z: Z)(`z=>y`: Z => Y): M[Z] => M[Y] =
    liftFunction(`z=>y`)

  private[pdbp] def lift2[Z, Y, X](
      `(z&&y)=>x`: (Z && Y) => X): (M[Z] && M[Y]) => M[X] =
    liftOperator(`(z&&y)=>x`)  

  private[pdbp] def lift3[Z, Y, X, W](`(z&&y&&x)=>w`: (Z && Y && X) => W)
    : (M[Z] && M[Y] && M[X]) => M[W] =
    `(z=>x)=>(z&&y)=>(x&&y)`(liftedAnd) andThen liftOperator(`(z&&y&&x)=>w`)

  // ...

}
```

`Lifting` comes with some other interesting computational capabilities.

  - `liftedAnd`, defined in terms of `liftOperator`

where

 - `` `(z&&y)=>(z&&y)` ``

is the program you expect.

```scala
package pdbp.utils

// ...

object productUtils {

  // ...

  def `(z&&y)=>(z&&y)`[Z, Y]: (Z && Y) => (Z && Y) = { `z&&y` =>
    `z&&y`
  }

  // ...      

}
```

  - `liftedApply`, defined in terms of `liftOperator`

where

 - `` `((z=>y)&&z)=>y` ``

is the program you expect.

```scala
package pdbp.utils

// ...

object productUtils {

  // ...

  def `((z=>y)&&z)=>y`[Z, Y]: ((Z => Y) && Z) => Y = { (`z=>y`, z) =>
    `z=>y`(z)
  }

  // ...     

}
```

`liftFunction` can be defined in terms of `liftObject` and `liftedApply` (and therefore in terms of `liftObject` and `liftOperator`).

Lifting does not stop with objects (`lift0`), unary functions (`lift1`) and binary operators (`lift2`).
It is possible to define lifting for ternary operators (`lift3`) and so on ... .

  - `lift3` is defined in terms of `liftOperator` and `liftedAnd`

where

 - `` `(z=>x)=>(z&&y)=>(x&&y)` ``

is the program you expect.

```scala
package pdbp.utils

// ...

object productUtils {

  // ...

  def `(z=>x)=>(z&&y)=>(x&&y)`[Z, Y, X]: (Z => X) => (Z && Y) => (X && Y) = {
    `z=>x` => (z, y) =>
      (`z=>x`(z), y)
  }

  // ...     

}
```

### **Defining lifting and programming capabilities in terms of computational capabilities**

#### **Defining lifting capabilities in terms of computational capabilities**

The lifting capabilities `liftObject`, `liftFunction` and `liftOperator` can be defined in terms of the computational capabilities `bind` and `result`.

```scala
package pdbp.computation

import pdbp.types.product.productType._

// ...

private[pdbp] trait Computation[M[+ _]]
    extends Resulting[M]
    with Binding[M]
    with Lifting[M]
    with Sequencing[M]
    with Program[Kleisli[M]] {

  override private[pdbp] def liftObject[Z](z: Z): M[Z] =
    result(z)

  override private[pdbp] def liftFunction[Z, Y](
      `z=>y`: Z => Y): M[Z] => M[Y] = { mz =>
    bind(mz, z => result(`z=>y`(z)))
  }

  override private[pdbp] def liftOperator[Z, Y, X](
      `(z&&y)=>x`: (Z && Y) => X): (M[Z] && M[Y]) => M[X] = { (mz, my) =>
    bind(mz, z => bind(my, y => result(`(z&&y)=>x`(z, y))))
  }

  // ...

}  
```

#### **Defining programming capabilities in terms of computational capabilities**

The programming capabilities `function`, `compose`, `product` and `sum` can be defined in terms of the computational capabilities `bind` and `result`.

```scala
package pdbp.computation

// ...

import pdbp.types.sum.sumType._

import pdbp.utils.sumUtils._

// ...

private[pdbp] trait Computation[M[+ _]]
    extends Resulting[M]
    with Binding[M]
    with Lifting[M]
    with Sequencing[M]
    with Program[Kleisli[M]] {

  private type `=>M` = Kleisli[M]

  override def function[Z, Y]: (Z => Y) => Z `=>M` Y = { `z=>y` => z =>
    result(`z=>y`(z))
  }

  override def compose[Z, Y, X](`z=>my`: Z `=>M` Y,
                                `y=>mx`: => Y `=>M` X): Z `=>M` X = { z =>
    bind(`z=>my`(z), `y=>mx`)
  }

  override def product[Z, Y, X](`z=>my`: Z `=>M` Y,
                                `z=>mx`: => Z `=>M` X): Z `=>M` (Y && X) = {
    z =>
      bind(`z=>my`(z), y => bind(`z=>mx`(z), x => result(y, x)))
  }

  override def sum[Z, Y, X](`y=>mz`: => Y `=>M` Z,
                            `x=>mz`: => X `=>M` Z): (Y || X) `=>M` Z =
    foldSum(`y=>mz`, `x=>mz`)

}
```

### **Defining computational capabilities in terms of programming and applying capabilities**

#### **Explaining `trait Applying`**

Consider 

```scala
package pdbp.demo.program

import pdbp.types.product.productType._

private[pdbp] trait Applying[>-->[- _, + _]] {

  private[pdbp] def apply[Z, Y]: (Z && (Z >--> Y)) >--> Y

}
```

Think of `apply` as a program that *applies* a program of type `Z >--> Y` to an argument of type `Z`.
It transforms the argument of type `Z` to yield a result of type `Y`.

#### **Augmenting computational capabilities with applying capabilities**

Computational capabilities can, trivially, be augmented with with applying capabilities.

```scala
package pdbp.computation

// ...

private[pdbp] trait Computation[M[+ _]]
    extends Resulting[M]
    with Binding[M]
    with Lifting[M]
    with Sequencing[M]
    with Program[Kleisli[M]] 
    with Applying[Kleisli[M]] {

  // ...

  private[pdbp] def apply[Z, Y]: (Z && (Z `=>M` Y)) `=>M` Y = { (z, `z=>my`) =>
    `z=>my`(z)
  }    

}
```

#### **Introducing `type Kleisli` for computations**

Consider

```scala
package pdbp.demo.types.kleisli

object kleisliComputationType {

  type Kleisli[>-->[- _, + _]] = [+Y] => Unit >--> Y

}
```

A computation of type `Kleisli[>-->]` is referred to as a *Kleisli computation*. 

#### **Defining computational capabilities in terms of programming and applying capabilities**

The computational capabilities `result` and `bind` can be defined in terms the of the programming capabilities `function` and `compose`, `product` and `apply`.

```scala
package pdbp.demo.program

import pdbp.program.Program

import pdbp.computation.Resulting
import pdbp.computation.Binding

import pdbp.demo.types.kleisli.kleisliComputationType._

private[pdbp] trait ProgramWithApplying[>-->[- _, + _]]
    extends Program[>-->]
    with Applying[>-->] 
    with Resulting[Kleisli[>-->]]
    with Binding[Kleisli[>-->]] {

  private type M = Kleisli[>-->]

  override private[pdbp] def result[Z]: Z => M[Z] =
    `z=>(u>-->z)`
      
  override private[pdbp] def bind[Z, Y](mz: M[Z], `z=>my`: => Z => M[Y]): M[Y] =
    compose(mz, compose(product(`z>-->u`, function(`z=>my`)), apply))

}
```

where

 - `` `z=>(u>-->z)` ``,
 - `` `z>-->u` ``

are the programs you expect.

```scala
package pdbp.program

// ...

trait Function[>-->[- _, + _]] {

  // ...

  def `z>-->u`[Z]: Z >--> Unit =
    function(`z=>u`)  

  def `z=>(y>-->z)`[Z, Y]: Z => (Y >--> Z) = { z =>
    function(`z=>(y=>z)`(z))
  }

  def `z=>(u>-->z)`[Z]: Z => (Unit >--> Z) =
    `z=>(y>-->z)`[Z, Unit]  

  // ...

}  
```

where

```scala
package pdbp.utils

object functionUtils {

  // ...

  def `z=>u`[Z]: Z => Unit = { z =>
    ()
  }

  def `z=>(y=>z)`[Z, Y]: Z => Y => Z = { z => y =>
    z
  }

}
```

## **Active program instance**

### **Introducing `activeTypes`**

The simplest computation instance (and corresponding program instance) one can probably think of is the *active* instance (we use active as opposed to *reactive*) as defined below

```scala
package pdbp.program.instances.active

import pdbp.types.active.activeTypes._

import pdbp.utils.functionUtils._

import pdbp.program.Program

import pdbp.computation.Computation

object activeProgram extends Computation[Active] with Program[`=>A`] {

  override private[pdbp] def result[Z]: Z => Active[Z] = `z=>az`

  override private[pdbp] def bind[Z, Y](
      az: Active[Z],
      `z=>ay`: => (Z => Active[Y])): Active[Y] = {
    `z=>ay`(az)
  }

}
```

where the types `Active` and `` `=>A` `` involved are defined as follows

```scala
package pdbp.types.active

import pdbp.types.kleisli.kleisliProgramType._

object activeTypes {

  type Active[+Z] = Z

  type `=>A` = Kleisli[Active]

}
```

and where

  - `` `z=>az` ``

is the program you expect

```scala
package pdbp.utils

import pdbp.types.active.activeTypes._

object functionUtils {

  // ...

  def `z=>az`[Z]: Z => Active[Z] = { z =>
    z
  }

}
```

### **`implicit` active program instance**

Let's move on and define an `implicit val` that we can use for dependecy injection by `import` later on.

```scala
package pdbp.program.implicits.active

import pdbp.program.instances.active.activeProgram

object implicits {

  implicit val implicitActiveProgram: activeProgram.type = activeProgram

}
```

## **Running `factorialMain`**

### **Defining`factorialObject`**

Consider

```scala
package objects.active

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits
import implicits.implicitActiveProgram

import examples.program.Factorial

object factorialObject extends Factorial[`=>A`]()
```

The definition of `factorialObject` uses dependecy injection by `import` (`import implicits.implicitActiveProgram`) to bring an `implicit val` (`implicitActiveProgram`) in scope to `extend` the *type class* `class Factorial`.

### **Defining `factorialMain`**

Consider

```scala
package examples.main.active

import examples.objects.active.factorialObject
import factorialObject.factorialMain

object FactorialMain {

  def main(args: Array[String]): Unit = {

    factorialMain(())

  }

}
```

The definition of `FactorialMain` uses dependecy injection by `import` (`import factorialObject.factorialMain`) to bring `factorialMain` in scope.

### **Running `factorialMain` using `activeProgram`**

Ok, so let's run our program.

Let's try `10`.

```scala
[info] Running examples.main.active.FactorialMain
please type an integer
10
the factorial value of the integer is
3628800
```

Let's try `100`.

```scala
[info] Running examples.main.active.FactorialMain
please type an integer
100
the factorial value of the integer is
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
```

Let's try `1000`.

```scala
[info] Running examples.main.active.FactorialMain
please type an integer
1000
[error] (run-main-0) java.lang.StackOverflowError
java.lang.StackOverflowError
```

We have a problem here. 
The active program instance *is not stack safe*. 
The good news is that the active instance is just one way to define a (in this case *language level*) *meaning* for the factorial *description*.



# **Appendices**

## **AppendixFunctionsAndExpressions**

Recall that

 - Pointful programming with computations is, in a way, similar to expression oriented, function application (argument binding) based programming with value (object) level expressions.
 - Pointfree programming with programs is, in a way, similar to function oriented, function composition based programming with function level expressions.

This appendix compares pointful and pointfree programming.

### **BindingOperator**

Recall that the `implicit class` below formalizes argument binding

```scala
package demo

object bindingOperator {

  implicit class BindingOperator[Z](z: Z) {

    def bind[Y](`z=>y`: Z => Y) = `z=>y` apply z

  }

}
```

### **Square root of sum of squares**

*The square root of the sum of the squares* of `z` and `y` can be defined as

 - `squareRoot(z * z + y * y)`,
   - where the *value level expression* `squareRoot(z * z + y * y)` is pointful, expression oriented and function application based.

It can also be defined as
 - `(squares andThen sum andThen squareRoot) apply (z, y)`, or
 - `(z, y)  bind (squares andThen sum andThen squareRoot)`, 
   - where the *function level expression* `squares andThen sum andThen squareRoot` is pointfree, function oriented and function composition based.

The code below illustrates, among others, how to go from the former one to the latter ones.

```scala
object FunctionsAndExpressions {

  val z = 3.0
  val y = 4.0

  type &&[+Z, +Y] = Tuple2[Z, Y]

  def main(args: Array[String]): Unit = {

    import scala.math.{sqrt => squareRoot}

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

    import bindingOperator.BindingOperator

    val result07: Double = (z, y) bind (squares andThen sum andThen squareRoot)

    val result08: Double = (z, y) bind squares bind sum bind squareRoot

  }

}
```

Note that argument binding naturally reads from left to right.

## **AppendixDefiningDescriptions**

Warning: the next appendices (before [AppendixVariance](#appendixvariance)) are elaborate ones.
This is intentional: the concepts they describe, *descriptions* and their *meanings* are important.

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

    import implicitly._

    val containedZero: C[Int] =
      contain(0)

    val containedTrue: C[Boolean] =
      contain(true)

  }

  // ...

}
```

`trait Description` is a *marker* `Dotty` type class. 

`trait Containing` is a `Dotty` type class declaring the capability to *contain a value*.

More precisely

 - `Containing[C[+ _]]` declares, using it's member `contain`, `C[+ _]`'s capability to contain a value.

We have also already defined some, agreed, very simple, descriptions, `containedZero` and `containedTrue` in terms of this declared capability.

`trait SomeValuesContainedIn[C[+ _]: Containing]`, declares `C[+ _]` to *implicitly* have the capability to contain a value. 
It defines descriptions `containedZero` and `containedTrue` using this `implicitly` available capability. 

Think of those descriptions as *recipes*

 - Take `0` and apply `contain` to it to make `containedZero`. 
   - Think of it as `0` contained in a, for now, *unknown* kind of, *(one element) container*.
 - Take `true` and apply `contain` to it to make `containedTrue`.
   - Think of it as `true` contained in a, for now, unknown kind of, (one element) container.

Note that, at this moment, no definition of the declared capability has been provided yet.

Below is another example

```scala
package demo

object DefiningDescriptions {

  // ...

  trait Covering[C[+ _]] extends Description[C] {

    def cover[Z](z: Z): C[Z]

  }

  trait SomeValuesCoveredBy[C[+ _]: Covering] {

    import implicitly._

    val coveredZero: C[Int] =
      cover(0)

    val coveredTrue: C[Boolean] =
      cover(true)

  }  

}
```

`trait Covering` is a `Dotty` type class declaring the capability to *cover a value*.

Again, we have also already defined some, agreed, very simple, descriptions, `coveredZero` and `coveredTrue`, in terms of this declared capability.

Note, again, that, at this moment, no definition of the declared capability has been provided yet.

## **AppendixLanguageLevelMeaning**

### **Defining declared `contain` capability for `Box`**

Let's go ahead and provide a first definition of the declared capability `contain`.

```scala
  case class Box[+Z](contained: Z)

  implicit object implicitBox extends Containing[Box] {

    override def contain[Z](z: Z): Box[Z] = Box(z)

  }
```

`implicitBox` is an `implicit object` that defines the capability `contain` that is declared in `trait Containing`. 

### **Defining declared `contain` capability for `Bag`**

Let's go ahead and provide a second definition of the declared capability `contain`.

```scala
  case class Bag[+Z](contained: Z)

  implicit object implicitBag extends Containing[Bag] {

    override def contain[Z](z: Z): Bag[Z] = Bag(z)

  }
```

`implicitBag` is an `implicit object` that defines the capability that is declared in `trait Containing`. 

### **Defining declared `cover` capability for `Cap`**

Let's go ahead and provide a first definition of the declared capability `cover`.

```scala
  case class Cap[+Z](covered: Z)

  implicit object implicitCap extends Covering[Cap] {

    override def cover[Z](z: Z): Cap[Z] = Cap(z)

  }
```

`implicitCap` is an `implicit object` that defines the capability `cover` that is declared in `trait Covering`. 

### **Defining declared `cover` capability for `Fez`**

Let's go ahead and provide a second definition of the declared capability `cover`.

```scala
  case class Fez[+Z](covered: Z)

  implicit object implicitFez extends Covering[Fez] {

    override def cover[Z](z: Z): Fez[Z] = Fez(z)

  } 
```

`implicitFez` is an `implicit object` that defines the capability that is declared in `trait Covering`. 

### **Language level meaning**

So far we have defined `implicit object`'s that define the capabilities that are declared in the type classes `trait Containing` and `trait Covering`.

Think of a them as *language level meanings*.

### **Defining descriptions in terms of language level meaning**

This simply boils down to defining `object`'s that depend on appropriate `implicit object`'s.

```scala
  object someValuesContainedInBox extends SomeValuesContainedIn[Box]()

  object someValuesContainedInBag extends SomeValuesContainedIn[Bag]()

  object someValuesCoveredByCap extends SomeValuesCoveredBy[Cap]()

  object someValuesCoveredByFez extends SomeValuesCoveredBy[Fez]()
```

### **Using `Box` language level meaning of `Containing`** 

We can now use values contained in a box

```scala
  def usingSomeValuesContainedInBox: Unit = {

    import someValuesContainedInBox._

    println(containedZero)
    println(containedTrue)

  }
```

Some values contained in a box are made available using `import someValuesContainedInBox._`.

This technique, called *dependency injection by* `import`, is used a lot in `Dotty`. 

In particular, for *type classes*, like `trait Containing`, dependency injection in `Dotty` boils down to

 - defining an appropriate `implicit object`,
 - doing an appropriate `import` of an `object` that depends on that `implicit object`.

### **Using `Bag` language level meaning of `Containing`**

We can now use values contained in a bag

```scala
  def usingSomeValuesContainedInBag: Unit = {

    import someValuesContainedInBag._

    println(containedZero)
    println(containedTrue)

  }
```

Again we use dependency injection by `import`.

### **Using `Cap` language level meaning of `Covering`** 

We can now use values covered by a cap

```scala
  def usingSomeValuesCoveredByCap: Unit = {

    import someValuesCoveredByCap._

    println(coveredZero)
    println(coveredTrue)

  }
```

Again, we use dependency injection by `import`.

### **Using `Fez` language level meaning of `Covering`**

We can now use values covered by a fez

```scala
  def usingSomeValuesCoveredByFez: Unit = {

    import someValuesCoveredByFez._

    println(coveredZero)
    println(coveredTrue)

  } 
```

Again, we use dependency injection by `import`.

### **Summary**

The most important takeway is that 

for `Containing`, once the `import` has been done, the rest of the code 
```scala
    println(containedZero)
    println(containedTrue)
```
*is the same* for `usingSomeValuesContainedInBag` and `usingSomeValuesContainedInBag`.

In this case we talk about only two lines of code, but, hopefully, you get the point.

for `Covering`, once the `import` has been done, the rest of the code 
```scala
    println(containedZero)
    println(containedTrue)
```
*is the same* for `usingSomeValuesCoveredByCap` and `usingSomeValuesCoveredByFez`.

In this case we talk about only two lines of code, but, hopefully, you get the point.

## **AppendixLibraryLevelMeaning**

So far we have described language defined meanings.

Now we go one step further by describing *library defined meanings*.

### **Natural transformation**

Before we continue, we describe *natural transformations*

```scala
  trait NaturalTransformation[From[+ _], To[+ _]] {
    def apply[Z](fz: From[Z]): To[Z]
  }
```

Natural transformations are like functions, but they work at the *type constructor* level instead of at the type level.

### **Defining `Meaning`**

```scala
  trait Meaning[From[+ _], To[+ _]] {
    def meaning: NaturalTransformation[From, To]
  }
```

`trait Meaning` *declares* the *meaning* of a type constructor `From` as a natural transformation `meaning` to a type constructor `To`.

### **Defining `ContainingMeaningOfContaining`**
 
```scala
  trait ContainingMeaningOfContaining[
      From[+ _]: Containing, To[+ _]: Containing]
      extends Meaning[From, To] {
    val implicitlyFrom = implicitly[Containing[From]]
    val implicitlyTo = implicitly[Containing[To]]
    override def meaning: NaturalTransformation[From, To] =
      new NaturalTransformation {
        override def apply[Z](fz: From[Z]): To[Z] = {
          implicitlyTo.contain(implicitlyFrom.contained(fz))
        }
      }
  }
```

`trait ContainingMeaningOfContaining` declares the meaning of a type constructor that is declared to implicitly have the capability to contain a value
in terms of type constructors that are declared to implicitly have the capability to contain a value. 

`meaning` is defined using those implicitly available capabilities. 

### **Defining `Containing` meaning of `Box`**

We can now define `trait ContainingMeaningOfBox` defining the meaning of `Box` in terms of type constructors that are declared to implicitly have the capability to contain a value.

```scala
  trait ContainingMeaningOfBox[C[+ _]: Containing]
      extends ContainingMeaningOfContaining[Box, C]
```

Below are two examples

```scala
  object bagMeaningOfBox
      extends ContainingMeaningOfBox[Bag]()
      with ContainingMeaningOfContaining[Box, Bag]()

  object boxMeaningOfBox
      extends ContainingMeaningOfBox[Box]()
      with ContainingMeaningOfContaining[Box, Box]()
```

### **Exploiting similarity**

So far we have defined `meaning` for `Containing` descriptions in terms of `Containing`.

`Containing` and `Covering` describe similar concepts. Maybe you can think of

  - a box as something covering something
  - a bag as something covering something
  - a cap as something containing something
  - a fez as something containing something

This is where the flexibility of library level declarations and definitions comes in.

### **Defining `CoveringMeaningOfContaining`**
 
```scala
  trait CoveringMeaningOfContaining[From[+ _]: Containing, To[+ _]: Covering]
      extends Meaning[From, To] {
    val implicitlyFrom = implicitly[Containing[From]]
    val implicitlyTo = implicitly[Covering[To]]
    override def meaning: NaturalTransformation[From, To] =
      new NaturalTransformation {
        override def apply[Z](fz: From[Z]): To[Z] = {
          implicitlyTo.cover(implicitlyFrom.contained(fz))
        }
      }
  }
```

`trait CoveringMeaningOfContaining` declares the meaning of a type constructor that is declared to implicitly have the capability to contain a value
in terms of type constructors that are declared to implicitly have the capability to cover a value. 

`meaning` is defined using those implicitly available capabilities. 

### **Defining `Covering` meaning of `Box`**

We can now define `trait ContainingMeaningOfBox` defining the meaning of `Box` in terms of type constructors that are declared to implicitly have the capability to cover a value.

```scala
  trait CoveringMeaningOfBox[C[+ _]: Covering]
      extends CoveringMeaningOfContaining[Box, C]
```

Below are two examples

```scala
  object capMeaningOfBox
      extends CoveringMeaningOfBox[Cap]()
      with CoveringMeaningOfContaining[Box, Cap]()

  object fezMeaningOfBox
      extends CoveringMeaningOfBox[Fez]()
      with CoveringMeaningOfContaining[Box, Fez]()
```

### **Defining `ContainingMeaningOfCovering`**
 
```scala
  trait ContainingMeaningOfCovering[From[+ _]: Covering, To[+ _]: Containing]
      extends Meaning[From, To] {
    val implicitlyFrom = implicitly[Covering[From]]
    val implicitlyTo = implicitly[Containing[To]]
    override def meaning: NaturalTransformation[From, To] =
      new NaturalTransformation {
        override def apply[Z](fz: From[Z]): To[Z] = {
          implicitlyTo.contain(implicitlyFrom.covered(fz))
        }
      }
  }
```

`trait CoveringMeaningOfContaining` declares the meaning of a type constructor that is declared to implicitly have the capability to cover a value
in terms of type constructors that are declared to implicitly have the capability to contain a value. 

`meaning` is defined using those implicitly available capabilities. 

### **Defining `Containing` meaning of `Cap`**

We can now define `trait ContainingMeaningOfCap` defining the meaning of `Cap` in terms of type constructors that are declared to implicitly have the capability to contain a value.

```scala
  trait ContainingMeaningOfCap[C[+ _]: Containing]
      extends ContainingMeaningOfCovering[Cap, C] 
```

`meaning` is defined using this `implicitly` available capability.

Below are two examples

```scala
  object boxMeaningOfCap
      extends ContainingMeaningOfCap[Box]()
      with ContainingMeaningOfCovering[Cap, Box]()

  object bagMeaningOfCap
      extends ContainingMeaningOfCap[Bag]()
      with ContainingMeaningOfCovering[Cap, Bag]()
```

### **Library level meaning**

So far we have defined `object`'s that define `meaning` that is declared in `trait Meaning`.
Think of a them as *library level meanings*

### **Use `Bag` library level `Containing` meaning for `Box`**
      
We can now use the bag meaning of values contained in a box

```scala
  def usingBagMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import bagMeaningOfBox.meaning

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }
```

For `trait Meaning` we also use dependency injection by `import`.

### **Use `Box` library level `Containing` meaning for `Box`**
      
We can now use the box meaning of values contained in a box

```scala
  def usingBoxMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import boxMeaningOfBox.meaning

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }
```

Again we use dependency injection by `import`.

### **Use `Cap` library level `Covering` meaning for `Box`**
      
We can now use the cap meaning of values contained in a box

```scala
  def usingCapMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import capMeaningOfBox.meaning

    println(meaning(containedZero))
    println(meaning(containedTrue))

  } 
```

Again we use dependency injection by `import`.

### **Use `Fez` library level `Covering` meaning for `Box`**
      
We can now use the box meaning of values contained in a box

```scala
  def usingFezMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import fezMeaningOfBox.meaning

    println(meaning(containedZero))
    println(meaning(containedTrue))

  } 
```

Again we use dependency injection by `import`.

### **Use `Box` library level `Containing` meaning for `Cap`**
      
We can now use the box meaning of values covered by a cap

```scala
  def usingBoxMeaningOfValuesCoveredByCap: Unit = {

    import someValuesCoveredByCap._
    import boxMeaningOfCap.meaning

    println(meaning(coveredZero))
    println(meaning(coveredTrue))

  } 
```

Again we use dependency injection by `import`.

### **Use `Bag` library level `Containing` meaning for `Cap`**
      
We can now use the bag meaning of values covered by a cap

```scala
  def usingBagMeaningOfValuesCoveredByCap: Unit = {

    import someValuesCoveredByCap._
    import bagMeaningOfCap.meaning

    println(meaning(coveredZero))
    println(meaning(coveredTrue))

  }
```

Again we use dependency injection by `import`.

### **Summary**

The most important takeway is that, 

for `Containing`, once the `import`'s have been done, the rest of the code 
```scala
    println(meaning(containedZero))
    println(meaning(containedTrue))
```
*is the same* for `usingBoxMeaningOfValuesCoveredByCap` and usingBagMeaningOfValuesCoveredByCap, usingCapMeaningOfValuesContainedInBox and `usingFezMeaningOfValuesContainedInBox`.

In this case we talk about only two lines of code, but, hopefully, you get the point.

for `Covering`, once the `import`'s have been done, the rest of the code 
```scala
    println(meaning(coveredZero))
    println(meaning(coveredTrue))
```
*is the same* for `usingBoxMeaningOfValuesCoveredByCap` and `usingBagMeaningOfValuesCoveredByCap`.

In this case we talk about only two lines of code, but, hopefully, you get the point.

## **AppendixVariance**

Consider 

```scala
package demo

object Variance {
  
  trait SuperZ

  trait Z extends SuperZ

  trait Y

  trait SubY extends Y

  val `z=>y`: Z => Y = new (SuperZ => SubY) { 
    override def apply(superZ: SuperZ): SubY = ??? 
  } 
  
}
```

The code above shows that, for the `Dotty` compiler, it is perfectly fine to use a `SuperZ => SubY` where a `Z => Y` is expected. 

## **Changes**

