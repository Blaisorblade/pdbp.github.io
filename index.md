# **Program Description Based Programming**

## **Warning**

 - This document and the library it describes are opiniated.
 - This is work in progress. Expect frequent changes.

Before starting, let's present a bit of history.

## **History**

In 1977, [John Backus](https://en.wikipedia.org/wiki/John_Backus) was an [ACM](https://www.acm.org/) [A.M. Turing Award Winner](https://amturing.acm.org/award_winners/backus_0703524.cfm).
The title of his Turing Award winning lecture was 

*Can programming be liberated from the von Neumann style? A functional style and it's algebra of programs.*

This document builds upon the ideas of this influential lecture.

## **Introduction**

When writing an introduction it is challenging to find the right balance between providing *too many* details or *too few* details. 
This introduction provides *many* details. 
It is perfectly fine to read this introduction *diagonally*.


### **Introducing `FP`**

In his Turing Award winning lecture, John Backus describes the [*function level* programming language `FP`](https://en.wikipedia.org/wiki/FP_%28programming_language). 

The `FP` programming language consists of *objects*, *programs*, *forms* and *definitions*, where

 - a program transforms objects to an object,
 - a form transforms programs to a program,
 - a definition defines a program or a form in terms of programs and forms.

Think of forms as *program templates* and programs transformed by them as *program fragments*, or *program components* that can be plugged into them to obtain a *composite program*.

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

`trait Program` exposes a *pointfree* programming API for *application developers*.
All it's capabilities are `public`, the default in `Dotty`.
Pointfree programming using `trait Program` is *program oriented* and *composition* based.

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
Pointful programming using `trait Computation` is *computation oriented* and *result binding* based.

In a way computations generalize *expressions*. 

 - An expression *evaluation* yields an *expression result*. 
 - A computation *execution* also, *somehow*, yields a *computation result*. 

When there is no danger of confusion we are simply going to write *result*, not mentioning *expression* or *computation*.

### **Introducing `type Kleisli`**

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

 - Monad based computations can use a pointfree programming style by making use of [*Kleisli categories*](https://en.wikipedia.org/wiki/Kleisli_category). 
 - Arrow based programs can use a pointful programming style by making use of [*arrow calculus*](http://homepages.inf.ed.ac.uk/slindley/papers/arrow-calculus.pdf).

**Our library goes for programming monads in a pointfree style using Kleisli functions.**

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

#### **About functions and expressions**

Recall that

 - In a way, programs generalize functions. 
 - In a way, computations generalize expressions.

*AppendixFunctionsAndExpressions* has demo code that compares 
 - pointful expression oriented and result binding (function application) based programming
 - pointfree function oriented and composition (function composition) based programming 

#### **About descriptions**

Recall that

 - Program descriptions are defined in terms of programming capabilities that are declared in the type class `trait Program`.
 - Computation descriptions are defined in terms of computational capabilities that are declared in the type class `trait Computation`.

*AppendixDefiningDescriptions* has demo code where descriptions are defined in terms of capabilities that are declared in a type class.

### **Elegance of use**

Programming is not only about power of expression. 
It is also, and probably even more, about *elegance of use*. 
Traditionally the pointfree style has been considered to be elegant by some programmers and *abstruse* by other programmers. 
Luckily, the `Dotty` programming language comes to the rescue for the latter ones. 
`Dotty` is a *strongly typed*, *scalable* programming language. 
It is possible to *extend the language* in a *type safe* way at the *library* level with *internal domain specific languages*. 

By using a *domain specific language for the domain of programs*, program description based programming can be done in a very elegant way.

**Of course, elegance of use is a highly subjective concept.** 

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
   - think of `isZero` as a *predicate* that transforms its argument to yield the result `true` if it is equal to `0` and to yield the result`false` otherwise 
 - `one` is a program description of type `BigInt >--> BigInt`
   - think of `one` as a *constant function* that transforms its argument to yield the result `1`
 - `subtractOne` is a program description of type `BigInt >--> BigInt`
   - think of `subtractOne` as a function that transforms its argument to yield the result obtained by *subtracting* `1` from it
 - `multiply` is a program description of type `(BigInt && BigInt) >--> BigInt`
   - think of `multiply` as a function that transforms its *two* arguments to yield the result obtained by *multiplying* them

  - `isZero`, `one` and `subtractOne` are programs with parameter type `BigInt`: one parameter of type `BigInt`.
  - `multiply` is a program with parameter type `BigInt && BigInt`: two parameters of type `BigInt`.

Below is an *informal explanation* of the *program templates* of the `factorial` program description above

 - `first >--> second`  is part of the `Dotty` program description DSL related to `Composition`
   - think of `first` as a *first* function that transforms an argument and `second`as a *second* function that transforms the result yielded by the first function  
 - `` `let` { constructNewUsingCurrent } `in` { useBothNewAndCurrent } `` is part of the `Dotty` program description DSL related to `Construction`
   - note that `let` and `in` are between *backticks*
   - think of `constructNew` as a function that *constructs* a *new* value using the *current* one
   - think of `useBothNewAndCurrent` as a function that uses both the *new* value and the *current* value 
   - together, the new value and the old current value become the new current value 
 - `` `if`(predicate) { trueCase } `else` { falseCase } `` is part of the `Dotty` program description DSL related to `Condition`
   - note that `if` and `else` are between *backticks*
   - think of `predicate` as a predicate that tests the current value 
   - if `true`, them function `trueCase` takes over control
   - if `false`, them function `falseCase` takes over control

Agreed, at first sight the pointfree `factorial` code above may seem a bit abstruse.
Agreed, we explained the pointfree code above in a pointful way.

Once you get used to
 - ` ... >--> ... `, 
 - `` `if`(...) { ... } `else` { ... } ``,  
 - `` `let` { ... } `in` { ... } ``, 
you will, hopefully, start appreciating the power of expression and elegance of use of pointfree code.


### **`FP` versus `PDBP`**

There is an important difference between `FP` programs and `Dotty` programs. 

 - `FP` programs are *language* based.
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

*AppendixLanguageLevelMeaning* has demo code where meanings are described at the *language level*.

*AppendixLibraryLevelMeaning* has demo code where meanings are described at the *library level*.

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

A program description performing I/O can be given both an *effectfree* meaning for *testing* purposes and various *effectful* meanings for different deployment scenario's. 

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

 - **You only have to concentrate on power of expression, elegance of use and flexibility of meaning.** 
 - **Pointfree program description based application programming naturally leads to deep insights into the nature of programs since it requires you to reason at an elegant (and reasonably powerful) level of abstraction.** 
 - **Pointful computation description based library programming naturally leads to deep insights into the nature of computations since it allows you to reason at a powerful (and reasonably elegant) level of abstraction.** 

Hopefully, the statements above sounds exiting to both programmers with and programmers without a background in computer science.








