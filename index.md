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

In a way programs generalize *functions*. 

 - A function transforms *function arguments* to yield a *function result*. 
 - A program also, *somehow*, transforms *program arguments* to yield a *program result*. 

When there is no danger of confusion we are simply write *arguments* and *result*, not mentioning *function* or *program*.

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
Computation descriptions are defined in terms of *computational capabilities* that are declared as members of `trait Computation`.

By abuse of notation, we often simply refer to computation descriptions as *computations*. 
We hope that this does not lead to any confusion.

`trait Computation` exposes a *pointful* programming API for *library developers*.
All it's capabilities are `private[pdbp]`.

In a way computations generalize *expressions*. 

 - An expression *evaluation* yields an *expression result*. 
 - A computation *execution* also, *somehow*, yields a *computation result*.

When there is no danger of confusion we are simply write *result*, not mentioning *expression* or *computation*.

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

### **Introducing `type Kleisli`**

The `with Program[[-Z, + Y] => Z => M[Y]]` part of `trait Computation`, which states that computations have more power of expression than programs, is a bit verbose.

Using the *type alias* `type Kleisli` below

```scala
package pdbp.types.kleisli

object kleisliFunctionType {

  type Kleisli[M[+ _]] = [-Z, + Y] => Z => M[Y]

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

### **`Program`**

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

We also use argument and result as default. 

#### **Variance**

Note that `>-->` is

 - *contravariant* in its argument type,
 - *covariant* in its result type.

[AppendixVariance](#appendixvariance) has demo code that illustrates this.

This *variance* property of `>-->` is related to two *principles* that are known as

 - the [*Liskov Substitution Principle*](https://en.wikipedia.org/wiki/Liskov_substitution_principle) which, roughly speaking, states
   - *require less* and *provide more*, 
 - the [*Internet Robustness Principle*](https://en.wikipedia.org/wiki/Robustness_principle) which, roughly speaking, states 
   - *be conservative in what you send* and *be liberal in what you receive*.

### **Many arguments resp. results**

Programs are objects of type `Z >--> Y`.

It may look as if programs can have only *one* argument resp. result.

The `PDBP` library encodes *many* arguments resp. results as *nested tuples*.

Consider

```scala
package pdbp.types.product

object productType {

  type &&[+Z, +Y] = Tuple2[Z, Y]
  
}
```

The product *type alias* above will be used throughout the library to deal with many arguments resp. results.

  - `Z && Y` for two of them
  - `Z && (Y && X)` for three of them
  - `Z && (Y && (X && W)` for four of them
  - ...  

### **Explaining `trait Function`**

Consider

```scala
package pdbp.program

trait Function[>-->[- _, + _]] {

  def function[Z, Y](`z=>y`: Z => Y): Z >--> Y

  // ...

}
```

`` function(`z=>y`) `` is a program that is a *pure function* `` `z=>y` ``. 
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

When dealing with more complex expressions, having nested sub-expressions, the usefulness of generic backtick names becomes even more apparent. 

By the way, note that argument bindings can, conveniently, be read from left to right. 

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

where

```scala
package pdbp.utils

object functionUtils {

  def `z=>z`[Z]: Z => Z = { z =>
    z
  }

  // ...

} 
```

We defined `` `z>-->z` `` in terms of `function` and `` `z=>z` `` where the function `` `z=>z` `` is the one you expect.
For programs, we use generic backtick names like `` `z>-->y` `` to, hopefully, improve readability. 

You may have doubts about the usefulness of a trivial program like`` `z>-->z` ``.  
It turns out that, when defining more complex *composite programs*, obtained by plugging *program components*, into *program templates*, replacing one or more of the components, by `` `z>-->z` `` results in interesting programs of their own.

### **Explaining `trait Composition`**

Consider

```scala
package pdbp.program

trait Composition[>-->[- _, + _]] {

  def compose[Z, Y, X](`z>-->y`: Z >--> Y, `y>-->x`: => Y >--> X): Z >--> X

}
```
Think of `compose` as a program template and of `` `z>-->y` `` and `` `y>-->x` `` as program fragments.

The program `` composition(`z>-->y`, `y>-->x`) `` is the *sequential composition* of the program `` `z>-->y` `` and the program `` `y>-->x` ``. 

If the program `` `z>-->y` `` transforms an argument of type `Z` to yield a result of type `Y`, 
then that result serves as an argument for the *subsequent* program `` `y>-->x` `` which transforms it to yield a result of type `X`.

Note that `` `y>-->x` `` is a *call-by-name parameter*.
If program `` `z>-->y` `` fails to yield a result, then program `` `y>-->x` `` is not used.  

Consider

```scala
object compositionOperator {

  implicit class CompositionOperator[>-->[- _, + _]: Composition, -Z, +Y](
      `z>-->y`: Z >--> Y) {

    def >-->[X](`y>-->x`: => Y >--> X) = {
      implicitly.compose(`z>-->y`, `y>-->x`)
    }

  }

}
```

  - `compose` comes with an *operator* equivalent `>-->`. 

The type constructor `>-->` is declared to implicitly have the programming capability `compose` that is declared in the the type class `trait Composition`. The operator `>-->` is defined in terms of this declared programming capability. The definition uses `implicitly`, an abbreviation for `implicitly[Composition[>-->]]`, that is available as an *implicit evidence* having the `compose` capability of `Composition`.

`` /* ... */ >--> /* ... */ `` is a first example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor. 

  - It should not come as a surprise that `` `z>-->y` >--> `y>-->x` `` has type `Z >--> X`.

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

 - `` `(y&&x)>-->(y&&x)` `` is the program you expect,
 - `` `(z&&y)>-->z` `` is the program you expect,
 - `` `(z&&y)>-->y` `` is the program you expect.

The programs above are defined below

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

}
```

Think of `product` as a program template and of `` `z>-->y` `` and `` `x>-->x` `` as program fragments.

The program `` product(`z>-->y`, `z>-->x`) `` that *constructs* a result from the results of the programs, `` `z>-->y` `` and `` `z>-->x` ``.

If the program `` `z>-->y` `` transforms an argument of type `Z` to yield a result of type `Y`, 
and the program `` `z>-->y` `` transforms that argument to yield a result of type `Y`,
then the program `` product(`z>-->y`, `z>-->x`) `` transforms that argument to yield a result of type `Y && X`.

Think of *one* object of type `Y && X` as *two* objects. More precisely, both an object of type `Y` and an object of type `X`. This is the way the `PDBP` library deals with two results of a program and two arguments of subsequent programs.

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

    def &[ZZ <: Z, X](`zz>-->x`: => ZZ >--> X) =
      implicitly.product(`z>-->y`, `zz>-->x`)

    def &&[X, W](`x>-->w`: => X >--> W) =
      implicitly.and(`z>-->y`, `x>-->w`)

  }

}
```

  - `product[Z, Y, X]` comes with an operator equivalent `&`.
  - `and[Z, Y, X, W]` comes with an operator equivalent `&&`.

The type constructor `>-->` is declared to implicitly have the programming capabilities `product` and `and` that are declared in the the type class `trait Construction`. The operators `&` and `&&` are defined in terms of those declared programming capabilities. The definitions use `implicitly`, an abbreviation for `implicitly[Construction[>-->]]`, that is available as an implicit evidence having the `product` and `and` capabilities of `Construction`.

`` /* ... */ & /* ... */ `` and `` /* ... */ && /* ... */ `` are a third and fourth example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor. 

It should not come as a surprise that `` `z>-->y` & `z>-->x` `` has type `Z >--> (Y && X)`.

It should not come as a surprise that `` `z>-->y` && `x>-->w` `` has type `(Z && X) >--> (Y && W)`.


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

 - `Containing[C[+ _]]` declares, using it's member `contain`, `C[+ _]`'s capability to contain a value.

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

Think of those descriptions as *recipes*

 - Take `0` and apply `contain` to it to make `containedZero`. 
   - Think of it as `0` contained in a, for now, *unknown* kind of, *one element container*.
 - Take `true` and apply `contain` to it to make `containedTrue`.
   - Think of it as `true` contained in a, for now unknown kind of, one element container.

At this moment no definition of the declared capability has been provided yet.

## **AppendixLanguageLevelMeaning**

### **Define declared capabilities**

Let's go ahead and provide a first definition of the declared capability `contain`.

```scala
  case class Box[+Z](unbox: Z)

  implicit object implicitBox extends Containing[Box] {

    override def contain[Z](z: Z): Box[Z] = Box(z)

  }
```

`implicitBox` is an `implicit object` that defines the capability `contain` that is declared in `trait Containing`. 

### **Define declared capabilities revisited**

Let's go ahead and provide a second definition of the declared capability `contain`.

```scala
  case class Wrap[+Z](unwrap: Z)

  implicit object implicitWrap extends Containing[Wrap] {

    override def contain[Z](z: Z): Wrap[Z] = Wrap(z)

  }
```

`implicitWrap` is an `implicit object` that defines the capability that is declared in `trait Containing`. 

### **Language level meaning**

So far we have defined `implicit object`'s that define the capabilities that are declared in the `Dotty` type class `trait Containing`.
Think of a them as *language level meanings*.

### **Defining descriptions in terms of language level meaning**

This simply boils down to defining `object someBoxedValues` that depends on `implicit object implicitBox`

```scala
  object someBoxedValues extends SomeValuesContainedIn[Box]()
```

### **Defining descriptions in terms of language level meaning revisited**

This simply boils down to defining `object someWrappedValues` that depends on `implicit object implicitWrap`

```scala
  object someWrappedValues extends SomeValuesContainedIn[Wrap]()
```

### **Use language level meaning**

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

 - defining an appropriate `implicit object`,
 - doing an appropriate `import` of an `object` that depends on that `implicit object`.

### **Use language level meaning revisited**

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
*is the same* for `usingBoxedValues` and `usingWrappedValues`.

In this case we talk about only two lines of code, but, hopefully, you get the point.

## **AppendixLibraryLevelMeaning**

### **Natural transformation**

Before continuing, we describe *natural transformations*

```scala
  trait NaturalTransformation[From[+ _], To[+ _]] {
    def apply[Z](fz: From[Z]): To[Z]
  }
```

Natural transformations are like functions, but they work at the *type constructor* level instead of at the type level.

### **Defining `MeaningOfContaining`**

So far we have described language defined meanings.

Now we go one step further by describing *library defined meanings*.

```scala
  trait Meaning[D[+ _], M[+ _]] {
    def meaning: NaturalTransformation[D, M]
  }
```

`trait Meaning` *declares* the *meaning* of a type constructor `D` (cfr. description) as a natural transformation `meaning` to a type constructor `M` (cfr. meaning). 

```scala
  trait MeaningOfContaining[C[+ _]: Containing, M[+ _]] extends Meaning[C, M]
```

`trait MeaningOfContaining` declares the meaning of a type constructor that is declared to implicitly have the capability to contain a value. 

### **Define declared meaning**

We can now define `trait MeaningOfBox` defining the meaning of `Box` in terms of type constructors that are declared to implicitly have the capability to contain a value.

```scala
  trait MeaningOfBox[C[+ _]: Containing] extends MeaningOfContaining[Box, C] {
    override def meaning: NaturalTransformation[Box, C] =
      new NaturalTransformation {
        override def apply[Z](bz: Box[Z]): C[Z] = {
          implicitly.contain(bz.unbox)
        }
      }
  }
```

`meaning` is defined using this `implicitly` available capability. 

We can now define `object wrapMeaningOfBox` defining the meaning of `Box` in terms of `Wrap`.

```scala
  object wrapMeaningOfBox 
      extends MeaningOfBox[Wrap]()
      with MeaningOfContaining[Box, Wrap]()
```

### **Define declared meaning revisited**

We can also define a more trivial meaning of `Box` in terms of `Box` itself.

```scala
  object boxMeaningOfBox
      extends MeaningOfBox[Box]()
      with MeaningOfContaining[Box, Box]()
```

### **Library level meaning**

So far we have defined `object`'s that define `meaning` that is declared in `trait Meaning`.
Think of a them as *library level meanings*

### **Use library level meaning**
      
We can now use the wrapped meaning of boxed values

```scala
  def usingWrappedMeaningOfBoxedValues: Unit = {

    import someBoxedValues._
    import wrapMeaningOfBox._

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }
```

For `trait Meaning` we also use *dependency injection* by `import`.

### **Use library level meaning revisited**
      
We can now also use the boxed meaning of boxed values

```scala
  def usingBoxedMeaningOfBoxedValues: Unit = {

    import someBoxedValues._
    import boxMeaningOfBox._

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }
```

Again we use dependency injection by `import`.

### **Summary**

The most important takeway is that, once the `import`'s have been done, the rest of the code 
```scala
    println(meaning(containedZero))
    println(meaning(containedTrue))
```
*is the same* for `usingWrappedMeaningOfBoxedValues` and `usingBoxedMeaningOfBoxedValues`.

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

