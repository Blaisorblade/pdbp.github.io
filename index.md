<style type="text/css"> body { margin: auto; max-width: 44em; font-family: Calibri, sans-serif; font-size: 18pt; } /* automatic heading numbering */ h1 { counter-reset: h2counter; } 
h2 { counter-reset: h3counter; } 
h3 { counter-reset: h4counter; } 
h4 { counter-reset: h5counter; } 
h5 { counter-reset: h6counter; } 
h6 { } 
h2:before { counter-increment: h2counter; content: counter(h2counter) ".\0000a0\0000a0"; } 
h3:before { counter-increment: h3counter; content: counter(h2counter) "." counter(h3counter) ".\0000a0\0000a0"; } 
h4:before { counter-increment: h4counter; content: counter(h2counter) "." counter(h3counter) "." counter(h4counter) ".\0000a0\0000a0"; } 
h5:before { counter-increment: h5counter; content: counter(h2counter) "." counter(h3counter) "." counter(h4counter) "." counter(h5counter) ".\0000a0\0000a0"; } 
h6:before { counter-increment: h6counter; content: counter(h2counter) "." counter(h3counter) "." counter(h4counter) "." counter(h5counter) "." counter(h6counter) ".\0000a0\0000a0"; } 
</style>

# **Program Description Based Programming**

This document describes the [`PDBP` library](https://github.com/PDBP/pdbp.github.io) written in the [`Dotty` programming language](http://dotty.epfl.ch/). 
The `Dotty` programming language will, eventually, evolve to version `3.0` of the [`Scala` programming language](https://www.scala-lang.org/).

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

## **About me**

I worked as a
 - mathematician (research and education),
 - programmer (research, education and consultancy).
 
I am retired now.

I am having fun with my wife Maritza

  - cycling with our race bicycles
    - climbing mountains, ...

Below is a link to picture, taken by a friend, of me and my wife, cycling in the French Alps.

[Luc and Maritza](./pictures/LucAndMaritza.JPG)

  - gardening in our green house
    - lettuce, cauliflower, tomato, bell pepper, ... .

Below is a link to picture of a radish I picked out of my greenhouse some time ago.

[Radish](./pictures/Radijs.png)

Below is a link to picture of a cauliflower I picked out of my greenhouse some time ago.

[Cauliflower](./pictures/Bloemkool.png)

Below is a link to picture of a typical lunch using vegetables of my greenhouse.

[Lunch](./pictures/Lunch.png)

Below is a link to picture of the first jalapeños I picked out of my greenhouse some time ago.

[Jalapeños](./pictures/Jalapenos.png)

As a hobby I am still having fun

  - programming 
    - bridging the gap between mathematical theory and programming practice.

I hope you enjoy the document below.

All comments are welcome [ pdbp.blog at gmail point com ].

## **Warning**      

First, let me be clear about the following
 - both this document and the library it describes are opiniated.

Second, this document is work in progress
 - expect frequent changes.

## **History**

Before starting, let's present a bit of history.

In 1977, [John Backus](https://en.wikipedia.org/wiki/John_Backus) was an [ACM](https://www.acm.org/) [A.M. Turing Award Winner](https://amturing.acm.org/award_winners/backus_0703524.cfm).
The title of his Turing Award winning lecture was 

*Can programming be liberated from the von Neumann style?* 

*A functional style and it's algebra of programs.*

This document builds upon the ideas of this influential lecture.

## **Introduction**

When writing an introduction it is challenging to find the right balance between providing *too many* details or *too few* details. 
This introduction provides (hopefully not too) many details. 
It is perfectly fine to read this introduction diagonally.

### **Introducing `FP`**

In his Turing Award winning lecture, John Backus describes the [`FP` programming language](https://en.wikipedia.org/wiki/FP_(programming_language)). 

The `FP` programming language consists of *objects*, *programs*, *forms* and *definitions*, where

 - a program transforms objects to an object,
 - a form transforms programs to a program,
 - a definition defines a program or a form in terms of programs and forms.

The `FP` forms are 

 - *Function*
 - *Composition*
 - *Construction*
 - *Condition*

Think of a form as a *program template*, programs transformed by them as *program fragments*, or *program components*, and the resulting program as *composite program*.

#### **Aggregation**

`FP` does not really have an *Aggregation* form. 
It does have *sequences of objects* and it is possible to define `FP` programs that *aggregate* sequences of objects to an object.

### **Introducing `PDBP`**

This document describes the [`PDBP` library](https://github.com/PDBP/pdbp.github.io) that is written in the [`Dotty` programming language](http://dotty.epfl.ch/). 
The `PDBP` library implements the `FP` programming language.

### **Objects and values**

In `Dotty`, every *value* is an *object*.
From now on, when dealing with `Dotty`, we use object and value interchangeably.

### **Introducing `trait Program`**

The main *type class* of the `PDBP` library is `trait Program`.

```scala
package pdbp.program

trait Program[>-->[- _, + _]]
    extends Function[>-->]
    with Composition[>-->]
    with Construction[>-->]
    with Condition[>-->]

    with Aggregation[>-->]
```

There is a one-to-one correspondence between `FP` forms and `trait`'s that are *mixed-in* by `trait Program` (agreed, strictly speaking, *Aggregation* is not an `FP` form).

`trait Program` closely resembles *arrows*.

In 1998, John Hughes described arrows and used arrows in `Haskell` in
[*Generalizing monads to arrows*](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.29.4575&rep=rep1&type=pdf).

`trait Program` is about *program descriptions*.
Program descriptions are *defined* in terms of *programming capabilities* that are *declared* as *members* of `trait Program`.

By abuse of notation, we often simply refer to program descriptions as *programs*. 
We hope that this does not lead to any confusion.

Compare this with the famous painting [Ceci n'est pas une pipe](https://en.wikipedia.org/wiki/The_Treachery_of_Images) of [René Magritte](https://en.wikipedia.org/wiki/Ren%C3%A9_Magritte). 

Below is a link to a picture of the painting.

[Ceci n'est pas une pipe](./pictures/Pipe.png)

The painting is not a pipe, it is a *description* of a pipe (you may even argue that the picture is a description of a painting which is a description of a pipe).

`trait Program` exposes a *pointfree* programming API for *application developers*.
All it's capabilities are `public`, the default in `Dotty`.

Below is a `factorial` program written using `trait Program`'s API .

```scala
package examples.programs

import pdbp.program.Program

class Factorial[>-->[- _, + _]: Program]
    extends AtomicPrograms[>-->]()
    with HelperPrograms[>-->]() {

  import implicitly._

  import pdbp.program.compositionOperator._

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

}
```

`val factorial` is defined in `class Factorial[>-->[- _, + _]: Program]` that is declared to *implicitly* have the programming capabilities declared in `trait Program[>-->[- _, + _]]`. Those programming capabilities are made available using `import implicitly._` and  `import pdbp.program.compositionOperator._`). The *atomic programs*, `isZero`, `one`, `subtractOne` and `multiply`, that `factorial` uses are defined in a similar way (only using `import implicitly._`).

In a way programs generalize *functions*. 

 - A function transforms *function arguments* to yield a *function result*. 
 - A program also, *somehow*, transforms a *program argument* to yield a *program result*. 

When there is no danger of confusion 
  - we simply write arguments, argument and result, not mentioning function or program.

So, we simply write
  - a function transforms arguments to yield a result, or
  - a function transforms arguments to a result, and
  - a program transforms an argument to yield a result, or
  - a program transforms an argument to a result.

Note that we use both (*zero or more*) arguments (for functions) and (*one*) argument (for programs).

One argument can be used to represent zero or more arguments using *products* (explained later in this document).

To finish, let's state that

 - pointfree programming using `trait Program` is *program oriented* and *program composition* based.


### **Introducing `trait Computation`**

Another important type class of the `PDBP` library is `trait Computation`.

```scala
package pdbp.computation

import pdbp.program.Program

private[pdbp] trait Computation[C[+ _]]
    extends Resulting[C]
    with Binding[C]
    // ...
    with Sequencing[C]
    
    with Program[[-Z, + Y] => Z => C[Y]]
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

Below is a `factorial` program written using `trait Computation`'s API .

```scala
package pdbp.examples.kleisliPrograms

import pdbp.computation.Computation

class Factorial[C[+ _]: Computation]
    extends AtomicKleisliPrograms[C]()
    with HelperKleisliPrograms[C]() {

  import pdbp.computation.bindingOperator._

  val factorial: BigInt `=>C` BigInt = { z =>
    isZero(z) bind { b =>
      if (b) {
        one(z)
      } else {
        subtractOne(z) bind { y =>
          factorial(y) bind { x =>
            multiply((y, x))
          }
        }
      }
    }
  }

}
```

There is an error in the  `factorial` definition above (did you spot it?). 
Here is a correct `factorial` definition 

```scala
  val factorial: BigInt `=>C` BigInt = { z =>
    isZero(z) bind { b =>
      if (b) {
        one(z)
      } else {
        subtractOne(z) bind { y =>
          factorial(y) bind { x =>
            multiply((z, x))
          }
        }
      }
    }
  }
```

The point we want to make is that pointful programming, because it is more complex than pointfree programming, is inherently more difficult (human brains can only deal with a limited amount of complexity).

`val factorial` is defined in `class Factorial[C[+ _]: Computation]` that is declared to implicitly have the computational capabilities declared in `trait Computation[C[+ _]]`. Those programming capabilities are made available using `import pdbp.computation.bindingOperator._`). The *atomic programs*, `isZero`, `one`, `subtractOne` and `multiply`, that `factorial` uses are defined in a similar way (using `import implicitly._`).

In a way computations generalize *expressions*. 

 - An expression *evaluation* yields an *expression result*. 
 - A computation *execution* also, *somehow*, yields a *computation result*.

When there is no danger of confusion 
  - we do not mention evaluation or execution, and
  - we simply write result, not mentioning expression or computation.

So, we simply write
  - an expression yields a result, or
  - an expression has a result, and
  - a computation yields a result, or
  - a computation has a result.

To finish, let's state that

 - pointful programming using `trait Computation` is *computation oriented* and *result binding* based.

### **Power of expression**

In 2008, Conor McBride and Ross Paterson described *applicatives* (a.k.a. *idioms*) and used applicatives in `Haskell` in 
[*Applicative programming with effects*](http://www.staff.city.ac.uk/~ross/papers/Applicative.pdf).

In 2008, Sam Lindley, Philip Wadler and Jeremy Yallop compared the *power of expression* of monads, arrows and idioms in 
[*Idioms are oblivious, arrows are meticulous, monads are promiscuous*](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.187.6750&rep=rep1&type=pdf). 

 - Monads (cfr. `Computation`) have most power of expression, 
 - applicatives (cfr. `Lifting`, described later) have least power of expression, and 
 - arrows (cfr. `Program`) are in between.

Recall that `Program[[-Z, + Y] => Z => C[Y]]` is mixed-in by `trait Computation`.

### **Elegance of use**

Programming is not only about power of expression. 
It is also, and probably even more, about *elegance of use*. 

Recall that

 - Monads (cfr `Computation`) naturally lead to a pointful programming style. 
 - Arrows (cfr. `Program`) naturally lead to a pointfree programming style. 

On the other hand

 - Monad based computations *can* use a pointfree programming style, cfr. [*Kleisli categories*](https://en.wikipedia.org/wiki/Kleisli_category). 
 - Arrow based programs *can* use a pointful programming style, cfr. [*arrow calculus*](http://homepages.inf.ed.ac.uk/slindley/papers/arrow-calculus.pdf).

Traditionally, the pointfree programming style has been considered to be elegant by some programmers and *abstruse* by other programmers. 
Luckily, the `Dotty` programming language comes to the rescue for the latter ones. 
`Dotty` is a *strongly typed*, *scalable* programming language. 
It is possible to *extend the language* in a *type safe* way at the *library* level with *internal domain specific languages*. 

By using a *domain specific language for the domain of programs*, program description based programming can be done in a very elegant way.

Of course, elegance of use is a highly subjective concept.
Personally, we consider program oriented composition based programming to be more elegant than computation oriented result binding based programming. 

### **Our choice**

`PDBP` goes for
 - A (slightly less) powerful, program oriented, elegant, and composition based, programming API for application developers.
 - A powerful, computation oriented, (slightly less) elegant, and result binding based, programming API for library developers. 

### **Introducing `type Kleisli` for binary type constructors**

You may argue that `Program[[-Z, + Y] => Z => C[Y]]` is a bit verbose.
Using the *type alias* named after [Heinrich Kleisli](https://en.wikipedia.org/wiki/Heinrich_Kleisli)

```scala
package pdbp.types.kleisli

private[pdbp] object kleisliBinaryTypeConstructorType {

  private[pdbp] type Kleisli[C[+ _]] = [-Z, + Y] => Z => C[Y]

}
```

`trait Computation` can be defined as follows

```scala
package pdbp.computation

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType.Kleisli

import pdbp.program.Program

private[pdbp] trait Computation[C[+ _]]
    extends Resulting[C]
    with Binding[C]
    // ...
    with Sequencing[C]    
    
    with Program[Kleisli[C]]
    // ...
``` 

A program of type `Kleisli[C]` is referred to as a *kleisli program* (note that we use a lower case *k*). 

Recall that

 - In a way, programs generalize functions. 
 - In a way, computations generalize expressions.

Think of

 - A function as an *expression template* with, to be filled in, *unknown parts* (its parameters).
   - for example `val function: Z => Y = { z => ey(x) }`
 - A kleisli program is a *computation template* with a, to be filled in, *unknown part* (its parameter).
   - for example `val kleislProgram: Z => C[Y] = { z => cy(x) }`

#### **Informal description of `factorial`**

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

Below is an *informal description* of the program fragments of the `factorial` program description above

 - `isZero` is a program description of type `BigInt >--> Boolean`
   - think of `isZero` as a *predicate* (`Boolean`-valued function) that transforms its argument to yield the result `true` if it is equal to `0` and to yield the result`false` otherwise,
 - `one` is a program description of type `Z >--> BigInt`
   - think of `one` as a *constant function* that transforms its argument to yield the result `1`,
 - `subtractOne` is a program description of type `BigInt >--> BigInt`
   - think of `subtractOne` as a function that transforms its argument to yield the result obtained by subtracting `1` from it,
 - `multiply` is a program description of type `(BigInt && BigInt) >--> BigInt`
   - think of `multiply` as a function that transforms its arguments to yield the result obtained by multiplying them.

Note that

  - `isZero`, `one` and `subtractOne` are programs with parameter type `BigInt`: one parameter of type `BigInt`,
  - `multiply` is a program with parameter type `BigInt && BigInt`: two parameters of type `BigInt`.

Also note that

  - `one` is a *generic* program description of type `Z >--> BigInt` *for all* `Z`

Below is an informal description of the program templates of the `factorial` program description above

 - `first >--> second` is part of the `PDBP` program description DSL related to `Composition`
   - think of `first` as a *first* function that transforms an argument and `second`as a *second* function that transforms the result yielded by the first function,
 - `` `let` { constructNewUsingCurrent } `in` { useBothNewAndCurrent } `` is part of the `PDBP` program description DSL related to `Construction`
   - note that `` `let` `` and `` `in` `` are between backticks,
   - think of `constructNewUsingCurrent` as a function that *constructs* a *new* value using the *current* one,
   - think of `useBothNewAndCurrent` as a function that uses both the *new* value and the *current* value, 
     - the new value and the old current value together, become the new current value,
 - `` `if`(predicate) { trueCase } `else` { falseCase } `` is part of the `PDBP` program description DSL related to `Condition`
   - note that `` `if` `` and `` `else` `` are between backticks,
   - think of `predicate` as a predicate (`Boolean`-valued function) that tests the current value,
     - if the result yielded by that test is `true`, then function `trueCase` takes over control,
     - if the result yielded by that test is `false`, then function `falseCase` takes over control.

Agreed, at first sight the pointfree `factorial` code above may seem a bit abstruse.

Agreed, we explained the pointfree code above in a pointful way.

But,

once you get used to program templates

 - ` ... >--> ... `, 
 - `` `if`(...) { ... } `else` { ... } ``,  
 - `` `let` { ... } `in` { ... } ``, 

and to program fragments like

 - `isZero`, 
 - `one`,
 - `subtractOne`,
 - `multiply`,

you will, hopefully, start appreciating the power of expression and elegance of use of pointfree code.

### **`FP` versus `PDBP`**

There is an important difference between `FP` programs and `PDBP` programs. 

 - `FP` programs are `FP` *language* based.
   - Think of `FP` programs as `FP` *programming language level syntactic constructs*.
 - `PDBP` programs are `Dotty` *library* based.
   - Think of `PDBP` programs as *programming domain specific, library language level, syntactic constructs*.

Exploiting the *flexibility* that comes with this difference is the most important theme of the `PDBP` library.

#### **Heteregeneous versus homogeneous**

 - `FP` is *heterogeneous*,
   -  programs are not objects.
 - `PDBP` is *homogeneous*,
   - in `Dotty`, everything is an object (value), in particular programs are objects (values).

Programs are defined in `class`es that are declared to *implicitly* have the programming capabilities declared in `trait Program[>-->[- _, + _]]`.
Those capabilities are made available using `import implicitly._` (many programming capabilities come with an operator equivalent that can be made avaialble by `import` as well).

Programming with `PDBP` is a lot about implicitly passing around programming capabilities and programming operators that may come with them.

#### **Semantics of programs**

 - in `FP`,
   - programs have *fixed semantics*
   - the implementation of `FP` defines the semantics of programs.
 - in `PDBP,`
   - programs have *flexible semantics* using
     - `implicit object`'s that `extend trait Program`
       - both simple `implicit object`'s and complex ones obtained by *naturally transforming* simpler ones, 
     - *program implementations* that, indirectly, depend on those `implicit object`'s
       - recall that programs are defined as members of `class`es that are declared to implicitly have programming capabilities,
       - `object`'s extending those `class`es directly depend on those `implicit object`'s and program implementations are available as members of those `object`'s,
     - `implicit object`'s that `extend trait ProgramMeaning`, that, by naturally transforming those program implementations, define the semantics of programs
       - both simple `implicit object`'s and complex ones obtained by naturally transforming simpler ones.

Agreed, the statements above may seem daunting at first sight, but they will become more familiar later in this document.

Let's rephrase the statements

  - we define a type class `trait Program`,
  - we define programs in `class`es that are declared to implicitly have the programming capabilities of `trait Program`,
  - we define `object`'s that `extend` those `class`es using *dependency injection by* `import` of `implicit object`'s that `extend trait Program`, making program implementations available as members of those `object`'s,
  - we define the semantics of programs by naturally transforming those program implementations using *dependency injection by* `import` of `implicit object`'s that `extend trait ProgramMeaning`

Strictly speaking, since `trait ProgramMeaning` is not a type class, the `object`'s that `extend trait ProgramMeaning` do not need to be `implicit object`'s, however, it is convenient that they are.

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

Note that `factorial` is a *recursive* `PDBP` program (`factorial` uses `factorial`).

It can be given both *stack* based semantics and, *tail recursive*, *heap* based semantics.

#### **Extra programming capabilities**

 - in `FP`
   - the set of forms of the language cannot be extended by adding extra forms.
 - in `PDBP`
   - the capabilities of the type class `trait Program` can be extended by mixing-in extra `traits`'s.

Extra programming capabilities can be added such as

 - *state manipulation*
 - *failure handling*
 - *latency handling* (using *parallelism*)
 - *advanced control handling* (using *delimited continuations*)
 - ...

Note that `Program` already has basic control handling (using the capabilities of `Condition`).

#### **I/O**

Also programming capabilities can be added related to

 - *input reading*
 - *output writing*

 - in `FP`
   - input and output are *effectful*, they *execute I/O effects* in an *impure* way.
 - in `PDBP`
   - input and output are *effectfree*, they *describe I/O effects* in an *pure* way. 

A program description involving I/O can be given 
 - different effectfree semantics for different *testing* purposes,
 - different effectful semantics for different *production* purposes. 

Reading and writing capabilities are, more or less, declared as

```scala
  trait Reading[Z, >-->[- _, + _]] {
    // ...

    def read: Unit >--> Z

    // ...
  }
```

and

```scala
  trait Writing[W: Writable, >-->[- _, + _]] {
    // ...

    def write[Y]: Y >--> Unit
  
    // ...
  }
```

A correct definition of `Reading` and `Writing` is described later in this document.

If `program` is a program of type `Z >--> Y`, then `read >--> program >--> write` is a program, referred to as a *main program*, of type `Unit >--> Unit`.

Note that, *syntactically*, `read` and `write` *describe* reading and writing effects in a *pure* way.
Syntactically, `read` and `write` come into play when *defining* main program descriptions.

Note that, *semantically*, `read` and `write` *may execute* reading and writing effects in an *impure* way.
Semantically, `read` and `write` come into play when, eventually, *using* main program descriptions in `def main(args: Array[String]): Unit`.

### **Main goal of the `PDBP` library**

The *main goal* of the `PDBP` library is to illustrate that program description based programming using a pointfree style in `Dotty` is 

 - *powerful*
   -  as a library developer you can use the expressive power of computations (monads),
   -  as an application developer you can use the expressive power of programs (arrows),
 - *elegant*
   - as an application developer you can use the elegance of the `Dotty` program DSL syntax,
   - as an library developer you can use the elegance the computations syntax,
 - *flexible*
   - as a library developer you can define many meanings,
   - as an application developer you can use many meanings,
 - *extendible*
   - as a library developer you can define extra capabilities,
   - as an application developer you can use extra capabilities,
 - *pure*
   - as a library developer you can define I/O in a pure way,
   - as a library tester you can use I/O in a pure way,
   - as an application developer you can use I/O in a impure way.

### **Summary**

For some of you this introduction may have touched upon a lot of frightening stuff. 

Here is the good news.

 - For now, you only have to concentrate on the concepts below
   - power of expression, 
   - elegance of use.

 - The concepts below
   - flexible meanings,
   - extra capabilities,
   - pure I/0,
   
   come in later.

To finish, we claim that

 - Pointfree program description based application programming naturally leads to deep insights into the nature of programs (remember: programs generalize functions). It requires you, as an application developer, to reason at an appropriate elegant (and reasonably powerful) level of abstraction. 
 - Pointful computation description based library programming naturally leads to deep insights into the nature of computations (remember: computations generalize expressions). It allows you, as a library developer, to reason at an appropriate, powerful (and reasonably elegant) level of abstraction.

Hopefully, the statements above sound exiting to both programmers with and programmers without a background in computer science.

## **Syntax of Program Descriptions**

### **Warning**

From now on this document contains a lot of code. 
When reading it in sequential order, you will often be confronted with code that has not been explained yet. 
Do not worry, the code is explained immediately below it. 

### **Describing `trait Program`**

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

`trait Program` is a *type class* that is explained later in this document. 
`trait Program` *declares* the *programming capabilities* of *program descriptions*. 

We often write *program* instead of *program description*.

Note that we were a bit sloppy by not showing `[>-->[- _, + _]]`.

`trait Function`, `trait Composition`, `trait Construction` and `trait Condition` are explained later in this section. 
`trait Aggregation` is explained later in this document. 

Note that, again, we were a bit sloppy by not showing `[>-->]`.

The programming capabilities of `Function`, `Composition` and `Construction` correspond to *arrows*. 

A program is an object of type `Z >--> Y`, where

 - `>-->` is a *binary type constructor*,
 - `Z` is the *parameter* (or *argument*) type of `>-->`,
 - `Y` is the *return* (or *result*) type of `>-->`.

We use

 - parameter and return if we want to be explicit about being at the *delaration* (or *definition*) site.

We use

 - argument and result if we want to be explicit about being at the *usage* site.

At the usage site the parameter is given an argument and a result is returned.

We also write that a program *transforms* an argument to yield a result.

#### **Variance**

Note that `>-->` is declared to be

 - *contravariant* in its parameter type,
 - *covariant* in its return type.

This *variance* property of `>-->` is related to two *principles* that are known as

 - the [*Liskov Substitution Principle*](https://en.wikipedia.org/wiki/Liskov_substitution_principle) which, roughly speaking, states
   - *consume less*,
   - *provide more*, 
 - the [*Internet Robustness Principle*](https://en.wikipedia.org/wiki/Robustness_principle) which, roughly speaking, states 
   - *be liberal in what you receive*,
   - *be generous in what you send*.

### **Describing `trait Function`**

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

For *generic functions*, we use *mixed alphabetic and symbolic names within backticks*, like `` `z=>y` `` to, hopefully, improve readability. 

*We agree that this is a somewhat unusual naming convention.*
*We know programers who love it, we know programmers who hate it.* 
 
Let's explain the reason of this naming convention with some examples that are special cases of [Theorems for free!](http://homepages.inf.ed.ac.uk/wadler/papers/free/free.dvi), as explained by Philip Wadler.

 - There is really only one generic function of type `Z => Z` *for all* `Z` : *identity*. 
   - The name `` `z=>z` ``, hopefully, suggests this function.
 - There is really only one generic function of type `(Z && Y) => Z` *for all* `Z` and `Y` : *left projection*. 
   - The name `` `(z&&y)=>z` ``, hopefully, suggests this function.
 - There is really only one generic function of type `(Z && Y) => Y` *for all* `Z` and `Y` : *right projection*. 
   - The name `` `(z&&y)=>y` ``, hopefully, suggests this function.
 - There is really only one generic function of type `(Z && Y) => Y && Z` *for all* `Z` and `Y` : *swap*. 
   - The name `` `(z&&y)=>y&&z` ``, hopefully, suggests this function. 
 - There is really only one generic function of type `(Z => Y && Z) => Y` *for all* `Z` and `Y` : *function application* (or, equivalently, *argument binding*). 
   - The name `` `(z=>y&&z)=>y` ``, hopefully, suggests this function.

We use synonyms like `` `y=>y` ``, `` `x=>x` ``, etc. by need, when types `Y`, `X`, etc. are involved.

We could have used names `identity`, `leftProjection`, `rightProjection` `swap` and `functionApplication`. 
Sometimes we would simply run out of meaningful generic names.

For example, how would you name the unique generic function of type `(Z && Y && X & WW) => W && X` *for all* `Z`, `Y`, `X`, and `W`?

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

Note that, in a way, the argument binding expression is the most elegant one since it can, conveniently, be read from left to right. 

When dealing with more complex expressions, having nested sub-expressions, the usefulness of generic backtick names becomes even more apparent. 

Let's define some pure functions.

```scala
package pdbp.program

import pdbp.utils.functionUtils._

trait Function[>-->[- _, + _]] {

  // ...

  def `z>-->z`[Z]: Z >--> Z =
    function(`z=>z`) 

  // ...   
  
} 
```

We defined `` `z>-->z` `` in terms of `function` and `` `z=>z` `` where 

  - `` `z=>z` `` 

is the function you expect.

```scala
package pdbp.utils

object functionUtils {

  // ...

  def `z=>z`[Z]: Z => Z = { z =>
    z
  }

  // ...

} 
```

For programs, we use generic backtick names like `` `z>-->y` `` to, hopefully, improve readability. 

You may have doubts about the usefulness of a trivial program like`` `z>-->z` ``.  
It turns out that, when defining composite programs, obtained by substituting program components, into program templates, using `` `z>-->z` `` for one or more of the components results in interesting composite programs of their own. Naturally, those composite programs have simpler types than the fully generic ones.

In what follows we also refer to programs `` function(`z=>y`) ``, that, essentially, are *pure functions*, as *atomic programs*. It is up to you to define the *granularity* of atomic programs.

#### **`factorial` as function**

Recall the definition of `factorial`

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

Below is another definition of `factorial`.

```scala
package examples.programs

import examples.utils.functionUtils._

import pdbp.program.Function

class FactorialAsFunction[>-->[- _, + _]: Function] {

  import implicitly._

  val factorialFunction: BigInt => BigInt = { i =>
    if (isZeroFunction(i)) {
      oneFunction(i)
    } else {
      multiplyFunction(i, (subtractOneFunction andThen factorialFunction)(i))
    }
  }

  val factorial: BigInt >--> BigInt = function(factorialFunction)

}
```

where

```scala
package examples.utils

import pdbp.types.product.productType._

object functionUtils {

  val isZeroFunction: BigInt => Boolean = { i =>
    i == 0
  }

  val subtractOneFunction: BigInt => BigInt = { i =>
    i - 1
  }

  val multiplyFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
    i * j
  }

  def oneFunction[Z]: Z => BigInt = { z =>
    1
  } 

  // ...

}
```

where

```scala
package pdbp.types.product

object productType {

  type &&[+Z, +Y] = Tuple2[Z, Y]

}
```

Since the atomic program `function(factorialFunction)` is very coarse-grained this gives us almost no flexibility to give a meaning to `factorial`.

### **Describing `trait Composition`**

Consider

```scala
package pdbp.program

trait Composition[>-->[- _, + _]] {

  def compose[Z, Y, X](`z>-->y`: Z >--> Y, `y>-->x`: => Y >--> X): Z >--> X

}
```

Think of `compose` as a *program template* (a.k.a. *higher order program*) and of `` `z>-->y` `` and `` `y>-->x` `` as *program fragment parameters* (a.k.a. *program component parameters* or simply *program parameters*).
Once the program fragment parameters have been given *program fragment arguments* (a.k.a. *program component arguments* or simply *program arguments*) we obtain a *composite program*.

Translated to functions:

Think of `compose` as a function template (a.k.a. *higher order function*) and of `` `z>-->y` `` and `` `y>-->x` `` as *function fragment parameters* (a.k.a. *function parameters*).
Once the function parameters have been given function fragment arguments (a.k.a. *function arguments*) we obtain a *composite function*.

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

The binary type constructor `>-->` is declared to *implicitly* have the programming capability `compose` that is declared in the type class `trait Composition`. The operator `>-->` is defined in terms of this declared programming capability. 

The definition uses `implicitly`, an abbreviation of `implicitly[Composition[>-->]]`, that is available as an *evidence* having the `compose` capability of `Composition`.

`` /* ... */ >--> /* ... */ `` is a first example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor. 

It should not come as a surprise that 

  - `` `z>-->y` >--> `y>-->x` `` has type `Z >--> X`.

### **Describing `trait Construction`**

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

  def left[Z, X, Y](`z>-->x`: Z >--> X): (Z && Y) >--> (X && Y) =
    and(`z>-->x`, `y>-->y`)

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

 - `` `(y&&x)>-->(y&&x)` ``,
 - `` `(z&&y)>-->z` ``, 
 - `` `(z&&y)>-->y` ``,
 - `` `y>-->y` ``

are the programs you expect.

```scala
package pdbp.program

// ...

import pdbp.types.product.productType._

import pdbp.utils.productUtils._

trait Function[>-->[- _, + _]] {

  // ...

  def `(y&&x)>-->(y&&x)`[Y, X]: (Y && X) >--> (Y && X) =
    function(`(y&&x)=>(y&&x)`)

  def `(z&&y)>-->z`[Z, Y]: (Z && Y) >--> Z =
    function(`(z&&y)=>z`)

  def `(z&&y)>-->y`[Z, Y]: (Z && Y) >--> Y =
    function(`(z&&y)=>y`)

  def `y>-->y`[Y]: Y >--> Y =
    function(`y=>y`)

  // ...

}
```

where

```scala
package pdbp.utils

import pdbp.types.product.productType._

object productUtils {

  // ...

  def `(y&&x)=>(y&&x)`[Y, X]: (Y && X) => (Y && X) = { `y&&x` =>
    `y&&x`
  }

  def `(z&&y)=>z`[Z, Y]: (Z && Y) => Z = { (z, _) =>
    z
  }

  def `(z&&y)=>y`[Z, Y]: (Z && Y) => Y = { (_, y) =>
    y
  }

  def `y=>y`[Y]: Y => Y = { y =>
    y
  }  

  // ...

}
```

Think of `product` as a program template and of `` `z>-->y` `` and `` `z>-->x` `` as program parameters.
Once the program parameters have been given program arguments we obtain a composite program.

`` product(`z>-->y`, `z>-->x`) `` yields a result *constructed* from the results yielded by `` `z>-->y` `` and `` `z>-->x` ``.

If the program `` `z>-->y` `` transforms an argument of type `Z` to yield a result of type `Y`, 
and the program `` `z>-->y` `` transforms that argument to yield a result of type `Y`,
then the program `` product(`z>-->y`, `z>-->x`) `` transforms that argument to yield a result of type `Y && X`.

#### **Many arguments resp. results**

Programs are objects of type `Z >--> Y`.

It may look as if programs can have only *one* argument resp. result.

Think of *one* object of type `Y && X` as *two* objects, one object of type `Y` and one object of type `X`. 
This is the way the `PDBP` library deals with *two* arguments resp. results.

Note that `Dotty` can also deal with many arguments the normal way using *argument lists*.

The `PDBP` library deals with *many* arguments resp. results using *nested tuples*

  - `Z && Y` for two of them,
  - `Z && Y && X` for three of them,
  - `Z && Y && X && W` for four of them,
  - ...  

Note that `&&` associates to the left, so, for example, `Z && Y && X` is the same type as the nested tuple `(Z && Y) && X`.

### **Describing `trait Construction` continued**

`trait Construction` has three other members

 - `product[Z, Y, X, W]` is a more complex version of `product[Z, Y, X]`,
 - `and[Z, Y, X, W]` is yet another more complex version of `product[Z, Y, X]`,
 - `` `let`[Z, Y, X] `` has a parameter that is a program fragment that *constructs a new result*, and `` `in` `` has a parameter that is a program fragment that has that result available as an *extra argument*.

The main difference between `` `let` { /* ... */ } `in` { /* ... */ } `` and `` /* ... */ >--> /* ... */ `` is that the former does not loose the original argument of type `Z` while the letter does. 

Note that

 - `product[Z, Y, X]` can be defined in terms of `product[Z, Y, X, W]` and `` `(y&&x)>-->(y&&x)` ``,
 - `product[Z, Y, X, W]` can be defined in terms of `product[Z, Y, X]` and `compose`,
 - `and[Z, Y, X, W]` can be defined in terms of `product[Z, Y, X]`, `` `(z&&y)>-->z` ``, `` `(z&&y)>-->y` `` and `compose`,
 - `` `let`[Z, Y, X] `` and `` `in` `` can be defined in terms of `product`, `` `z>-->z` `` and `compose`.

Note that the definitions are *left biased*. Their first parameter is a by-value parameter. Their second parameter is a by-name parameter. 

`` `let` { /* ... */ } `in` { /* ... */ } `` is a second example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor.

`trait Construction` has one other member

  - `left[Z, X, Y]` is a simpler version of `and[Z, Y, X, W]`

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

The type constructor `>-->` is declared to implicitly have the programming capabilities `product` and `and` that are declared in the type class `trait Construction`. The operators `&` and `&&` are defined in terms of those declared programming capabilities. 

The definitions use `implicitly`, an abbreviation of `implicitly[Construction[>-->]]`, that is available as an evidence having the `product` and `and` capabilities of `Construction`.

`` /* ... */ & /* ... */ `` and `` /* ... */ && /* ... */ `` are a third and fourth example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor. 

It should not come as a surprise that 

  - `` `z>-->y` & `z>-->x` `` has type `Z >--> (Y && X)`,
  - `` `z>-->y` && `x>-->w` `` has type `(Z && X) >--> (Y && W)`.

#### **About the power of expression of `` `let` { ... } `in` { ... } ``**

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

  // ...

}
```

The definition of `product` is an example of a recurring theme of the `PDBP` library.

*Defining a program, or programming capability, often boils down to a "getting the types right" puzzle*. 

Often there is only one meaningful way to get them right. 
Let's have a look at some of the details of the typing puzzle for this definition.

The outer `` `let` `` creates, using `` `z>-->y` ``, a new argument of type `Y` for the outer `` `in` `` which, as a consequence, has an argument of type `Z && Y` available, representing two arguments, one of type `Z` and one of type `Y`. 

The inner `` `let` `` of the outer `` `in` `` creates, using `` `(z&&y)>-->z` >--> `z>-->x` ``, the composition of `` `(z&&y)>-->z` `` and `` `z>-->x` ``, a new argument of type `X` for the inner `` `in` ``  of the outer `` `in` `` which, as a consequence, has an argument of type `Z && Y && X` available, representing three arguments, one of type `Z`, one of type `Y`, and one of type `X`. 

The inner `` `in` `` in the outer `` `in` `` simply gets rid of the original argument of type `Z` using `` `(z&&y&&x)>-->(y&&x)` ``.

Note that generic backtick names, hopefully, help to understand the typing puzzle. 

For example

  - in the composition `` `(z&&y)>-->z` >--> `z>-->x` ``, the matching `z`'s reflect the type `Z` involved,
  - in the name `` `(z&&y&&x)>-->(y&&x)` ``, both `(z&&y&&x)` and `(y&&x)` reflect the types `(Z && Y && X)` and `(Y && X)` involved.

One challenge that comes with pointfree programming is getting the *necessary* arguments out of *all* available arguments. 
The program `` `(z&&y&&x)>-->(y&&x)` `` above gets a `y` and an `x` out of a `z`, a `y` and an `x`. 

One way to deal with this challenge is to keep programs, and therefore, the arguments and results that come with them, relatively small. After all, small program components can be combined to obtain larger, composite programs by substituting them into program templates.

[*Erik Meijer*](https://en.wikipedia.org/wiki/Erik_Meijer_(computer_scientist)) refers to this programming paradigm in a somewhat funny way as 

*Good programmers write baby-code*. 

Erik Meijer is so famous that he does not need an introduction. 
I was very lucky to be able to do research with him, on monads and related stuff, at the Univeristy of Utrecht back in the ninetees.

### **Describing `trait Condition`**

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

Agreed, `` `(w&&b)>-->(w||w)` `` is one of the *two* programs you expect. 
It is the one where `true` corresponds to `Left` and  `false` corresponds to `Right`.

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

  // ...

}
```

where

```scala
package pdbp.utils

import pdbp.types.sum.sumType._

object sumUtils {

  // ...

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

  // ...

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

Think of `sum` as a program template and of `` `y>-->z` `` and `` `x>-->z` `` as program parameters.
Once the program parameters have been given program arguments we obtain a composite program.

`` sum(`y>-->z`, `x>-->z`) `` uses a *"left or right" condition* to let either `` `y>-->z` `` or `` `x>-->z` `` take over control.

### **Describing `trait Condition` continued**

`trait Condition` has three other members

 - `sum[Z, Y, X, W]` is a more complex version of `sum[Z, Y, X]`,
 - `or[Z, X, Y, W]` is yet another more complex version of `sum[Z, Y, X]`,
 - `` `if`[W, Z] `` has a parameter that is a program that has a result of type `Boolean` that is used to let either the program parameter of `apply` or the program parameter of `` `else` `` take over control.

Note that

 - `sum[Z, Y, X]` can be defined in terms of `sum[Z, Y, X, W]` and `` `(y||x)>-->(y||x)` ``,
 - `sum[Z, Y, X, W]` can be defined in terms of `sum[Z, Y, X]` and `compose`,
 - `and[Z, Y, X, W]` can be defined in terms of `product[Z, Y, X]`, `` `(z&&y)>-->z` ``, `` `(z&&y)>-->y` `` and `compose`,
 - `` `if`[W, Z] `` and `` `else` `` can be defined in terms of `sum`, `` `let` `` and `` `in` ``.

`` `if`(/* ... */) { /* ... */ } `else` { /* ... */ } `` is a fifth example where `Dotty` comes to the rescue to spice pointfree programming with some domain specific language flavor.  

#### **About the power of expression of `` `if`(...) { ... } `else` { ... }``**

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

Agreed, `` `(y||x)>-->b` `` is one of the two programs you expect. 
It is the one where `true` corresponds to `Left` and  `false` corresponds to `Right`.

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

Note that, again, generic backtick names, hopefully, help to understand the typing puzzle. 
For example

  - in the composition `` `(y||x)>-->y` >--> `y>-->z` ``, the matching `y`'s reflect the type `Y` involved, 
  - In the composition `` `(y||x)>-->x` >--> `x>-->z` ``, the matching `x`'s reflect the type `X` involved.

### **`factorial` revisited**

Below is, again, the full code for `factorial`.

```scala
package examples.programs

import pdbp.program.Program

class Factorial[>-->[- _, + _]: Program]
    extends AtomicPrograms[>-->]()
    with HelperPrograms[>-->]() {

  import implicitly._

  import pdbp.program.compositionOperator._

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

}
```

where

```scala
package examples.programs

import pdbp.types.product.productType._

import pdbp.program.Function

import examples.utils.functionUtils._

trait AtomicPrograms[>-->[- _, + _]: Function] extends HelperPrograms[>-->] {

  val isZero: BigInt >--> Boolean =
    isZeroHelper

  val subtractOne: BigInt >--> BigInt =
    subtractOneHelper

  val multiply: (BigInt && BigInt) >--> BigInt =
    multiplyHelper

  def one[Z]: Z >--> BigInt =
    oneHelper

}
```

and

```scala
package examples.programs

import pdbp.types.product.productType._

import pdbp.program.Function

import examples.utils.functionUtils._

trait HelperPrograms[>-->[- _, + _]: Function] {

  import implicitly._

  val isZeroHelper: BigInt >--> Boolean =
    function(isZeroFunction)

  val subtractOneHelper: BigInt >--> BigInt =
    function(subtractOneFunction)

  val multiplyHelper: (BigInt && BigInt) >--> BigInt =
    function(multiplyFunction)

  def oneHelper[Z]: Z >--> BigInt =
    function(oneFunction)

}
```

Since the atomic programs, `isZero`, `one`, `subtractOne` and `multiply` used by `factorial` are very fine-grained this gives us a lot of flexibility to give a meaning to `factorial`.

#### **`factorial` top-down**

Below is *top-down* code for `factorial`

```scala
package examples.programs

import pdbp.program.Program

class FactorialTopDown[>-->[- _, + _]: Program]
    extends AtomicPrograms[>-->]()
    with HelperPrograms[>-->]() {

  import implicitly._

  import pdbp.program.compositionOperator._

  val factorial: BigInt >--> BigInt =
    `if`(isZero) {
      one
    } `else` {
      factorialOfNonZero
    }

  val factorialOfNonZero: BigInt >--> BigInt =
    `let` {
      subtractOneAndThenFactorial
    } `in` {
      multiply
    }

  val subtractOneAndThenFactorial: BigInt >--> BigInt =
    subtractOne >-->
      factorial

}
```

`factorial` above uses 

  - the `` `if`(...) { ... } `else` { ... } `` program template of `trait Condition`.
  - the atomic program component `isZero`
  - the atomic program component `one`
  - the composite program component `factorialOfNonZero`

`factorialOfNonZero` above uses 

  - the `` `let` { ... } `in` { ... } `` program template of `trait Construction`.
  - the atomic program component `multiply`
  - the composite program component `subtractOneAndThenFactorial`

`subtractOneAndThenFactorial` above uses 

  - the `>-->` program template of `trait Composition` (more precisely, of `implicit class CompositionOperator`).
  - the atomic program component `subtractOne`
  - *recursively*, `factorial` itself as a composite program component

### **main programs**

Recall that programs have type `Z >--> Y` for types `Z` and `Y`.

For example: `factorial` has type `BigInt >--> BigInt`.

If

 - `` `u>-->z` `` is a *producer* program of type `Unit >--> Z`, where `u` corresponds to `Unit`,
 - `` `z>-->y` `` is a program of type `Z >--> Y`,
 - `` `y>-->u` `` is a *consumer* program of type `Y >--> Unit`, where `u` corresponds to `Unit`,

then

 - `` `u>-->z` >--> `z>-->y` >--> `y>-->u` `` is a *main program* of type `Unit >--> Unit`.

We also simply refer to 

  - a producer program as a *producer*,
  - a consumer program as a *consumer*.

#### **Describing `mainFactorial`**

Consider

```scala
package examples.mainPrograms

import pdbp.program.Program

import pdbp.program.compositionOperator._

import examples.programs.Factorial

trait MainFactorial[>-->[- _, + _]: Program] {

  private object factorialObject extends Factorial[>-->]

  import factorialObject.factorial

  val producer: Unit >--> BigInt

  val consumer: BigInt >--> Unit

  lazy val mainFactorial: Unit >--> Unit =
    producer >-->
      factorial >-->
      consumer

}
```

`trait MainFactorial` defines `lazy val mainFactorial` using abstract members `producer` and `consumer`.

## **Describing `trait Computation`**

### **Describing `trait Computation`**

Consider

```scala
package pdbp.computation

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType.Kleisli

import pdbp.program.Program

import pdbp.program.Applying

private[pdbp] trait Computation[C[+ _]]
    extends Resulting[C]
    with Binding[C]
    with Lifting[C]
    with Sequencing[C]
    with Program[Kleisli[C]]
    with Applying[Kleisli[C]]
```

where

```scala
private[pdbp] trait Resulting[C]

private[pdbp] trait Binding[C]

private[pdbp] trait Lifting[C]

private[pdbp] trait Sequencing[C]
```

belong to the same `package pdbp.computation`.

and where

```scala
package pdbp.types.kleisli

private[pdbp] object kleisliBinaryTypeConstructorType {

  private[pdbp] type Kleisli[C[+ _]] = [-Z, + Y] => Z => C[Y]

}
```

`trait Computation` is a type class that is explained later in this document. 
`trait Computation` declares the *computational capabilities* of *computation descriptions*. 

We often write *computation* instead of *computation description*.

Note that we were a bit sloppy by not showing `[C[+ _]]`.

`trait Resulting`, `trait Binding` and `trait Lifting` are explained later in this section. 
`trait Sequencing`, related to `trait Aggregation`, is explained later in this document. 
`trait Applying` is explained later in this document. 

Note that, again, we were a bit sloppy by not showing `[C]` and `Kleisli[C]`.

The computational capabilities of `Resulting` and `Binding` correspond to *monads*. 

A computation is an `object` of type `C[Z]`, where

 - `C` is a *unary type constructor*,
 - `Z` is the *return* (or *result*) type of `C`.

We write

 - return if we want to be explicit about being at the delaration (or definition) site.

We write

 - result if we want to be explicit about being at the usage site.

We also write that a computation yields a (or has a) result.

#### **`PDBP` library users versus `PDBP` library developers**

Note that all computational capabilities are defined as `private [pdbp]`. 

We do not want to expose the pointful computational capabilies to the *users* of the `PDBP` library. 
We only expose pointfree programming capabilities to the users of the `PDBP` library. 
It is convenient to have pointful computational capabilies available for the *developers* of the `PDBP` library. 
It is also *simpler* (not necessarily *easier*, though) to define `object`'s that `extend Computation`, since `Computation` has less declared capabilities to define than `Program`.

#### **Variance**

Note that `C` is

 - *covariant* in its result type.

This *variance* property of `C` is related to two principles that are known as

 - the [*Liskov Substitution Principle*](https://en.wikipedia.org/wiki/Liskov_substitution_principle) which, roughly speaking, states, among others
   - *provide more*, 
 - the [*Internet Robustness Principle*](https://en.wikipedia.org/wiki/Robustness_principle) which, roughly speaking, states, among others 
   - *be generous in what you send*.

### **Describing `trait Resulting`**

Consider

```scala
package pdbp.computation

private[pdbp] trait Resulting[C[+ _]] {

  private[pdbp] def result[Z]: Z => C[Z]

}
```

Think of `result(ez)` as a computation that is a *pure expression* `ez`. 
Executing it is supposed to do nothing else than *evaluating* the expression `ez` to a yield a result of type `Z`.

In what follows we also refer to computations `result(ez)`, that, essentially, are pure expression, as *atomic computations*. 
It is up to you to define the granularity of atomic computations.

### **Describing `trait Binding`**

Consider

```scala
package pdbp.computation

private[pdbp] trait Binding[C[+ _]] {

  private[pdbp] def bind[Z, Y](cz: C[Z], `z=>cy`: => Z => C[Y]): C[Y]

}
```

Think of `` `z=>cy` `` as a *computation execution continuation template* or, simply, *computation continuation template*, or *computation template*, and of `cz` as a *computation fragment* or *computation component* (a.k.a. *sub-computation*).

For computations, the *execution order* is imposed by the usage of `bind`.

Translated to expressions:

Think of `` `z=>cy` `` as an *expression evaluation continuation template*, or, simply, *expression template*, and of `cz` as an *expression fragment* or *expression component* (a.k.a. *sub-expression*).

For expressions the *evaluation order* is langauge defined (e.g. *bottom-up* and *left to right*),

`` bind(cz, `z=>cy`) `` is function that *binds* `cz` to `z=>cy` to *continue* the ongoing computation.

If the computation `cz` yields a result of type Z, then that result serves as an argument for the subsequent function `z=>cy`, a *computation continuation*, which transforms it to a computation that yields a result of type Y.

Consider

```scala

private[pdbp] object bindingOperator {

  implicit class bindingOperator[C[+ _] : Binding, -Z, ZZ <: Z](czz: C[ZZ]) {

    private[pdbp] def bind[Y](`zz=>cy`: ZZ => C[Y]): C[Y] =
      implicitly.bind(czz, `zz=>cy`)
  }

}
```

  - `bind[Z, Y]` comes with an operator equivalent `bind`,

#### **Warning about the next sections describing kleisli programs**

The idea behind `PDBP` is to promote pointfree programming.
The computation examples described in the next sections are pointful and should not be written by application developers.

Note that the package of the examples is `pdbp.examples.kleisliPrograms`. 

#### **`sumOfSquares` as computation**

Below is the code for `sumOfSquares`.

```scala
package pdbp.examples.kleisliPrograms

import pdbp.types.product.productType._

import pdbp.computation.Computation

import pdbp.computation.bindingOperator._

class SumOfSquares[C[+ _]: Computation]
    extends AtomicKleisliPrograms[C]()
    with HelperKleisliPrograms[C]() {

  import implicitly._

  val sumOfSquares: (Double && Double) `=>C` Double = { (z, y) =>
    square(z) bind { zSquare =>
      square(y) bind { ySquare =>
        sum(zSquare, ySquare) bind { zSquare_plus_ySquare =>
          result(zSquare_plus_ySquare)
        }
      }
    }
  }

}
```

where

```scala
package pdbp.examples.kleisliPrograms
package pdbp.examples.kleisliPrograms

import pdbp.types.product.productType._

import pdbp.computation.Resulting

import pdbp.examples.utils.functionUtils._

trait AtomicKleisliPrograms[C[+ _]: Resulting]
    extends HelperKleisliPrograms[C] {

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val square: Double `=>C` Double = squareHelper

  val sum: (Double && Double) `=>C` Double = sumHelper

  // ...

}
```

where

```scala
package pdbp.examples.kleisliPrograms

import pdbp.types.product.productType._

import pdbp.computation.Resulting

import pdbp.examples.utils.functionUtils._

trait HelperKleisliPrograms[C[+ _]: Resulting] {

  import implicitly._

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val squareHelper: Double `=>C` Double = squareFunction andThen result

  val sumHelper: (Double && Double) `=>C` Double = sumFunction andThen result

  // ...

}
```

where

```scala
package pdbp.examples.utils.functionUtils._

object functionUtils {

  // ...

  val squareFunction: Double => Double = { z =>
    z * z
  }

  val sumFunction: Double && Double => Double = { (z, y) =>
    z + y
  } 

  // ... 

}
```

Since the atomic kleisli programs , `square` and `sum` used by `sumOfSquares` are very fine-grained this gives us a lot of flexibility to give a meaning to `sumOfSquares`.

#### **`sumOfSquares` as expression**

Below is other code for `sumOfSquares`.

```scala
package pdbp.examples.kleisliPrograms

import pdbp.types.product.productType._

import pdbp.computation.Resulting

import pdbp.examples.utils.functionUtils._

class SumOfSquaresAsExpression[C[+ _]: Resulting] {

  import implicitly._

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val sumOfSquaresFunction: Double && Double => Double = { (z, y) =>
    sumFunction(squareFunction(z), squareFunction(y))
  }

  val sumOfSquares: (Double && Double) `=>C` Double =
    sumOfSquaresFunction andThen result

}
```

Since the atomic kleisli program `sumOfSquares` is very coarse-grained this gives us almost no flexibility to give a meaning to `sumOfSquares`.

### **main kleisli programs**

Recall that kleisli programs have type `Z => C[Y]` (or `` Z `=>C` Y ``, using an appropriate type synonym) for types `Z` and `Y`.

For example: `sumOfSquares` has type `` (Double && Double) `=>C` Double ``.

If

`producer` is a producer kleisli program of type `` Unit `=>C` Z ``,
`` `z=>cy` `` is a kleisli program of type `` Z `=>C` Y ``,
`consumer` is a consumer kleisli program of type `` Y `=>C` Unit ``,
then

`` { u => producer(u) bind { z => `z=>cy`(z) bind { y => consumer(y) } } }`` is a *main kleisli program* of type `` Unit `=>C` Unit ``.

We also simply refer to

 - a producer kleisli program as a producer,
 - a consumer kleisliprogram as a consumer.

Note that the code for a main kleisli program is more complex (and, as a consequence, imho, less elegant) than the code for a main program.

#### **Describing `mainSumOfSquares` as computation**

Consider

```scala
package pdbp.examples.mainKleisliPrograms

import pdbp.types.product.productType._

import pdbp.computation.Computation

import pdbp.examples.kleisliPrograms.SumOfSquares

trait MainSumOfSquares[C[+ _]: Computation] {

  import pdbp.computation.bindingOperator._

  private object sumOfSquaresObject extends SumOfSquares[C]

  import sumOfSquaresObject.sumOfSquares

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val producer: Unit `=>C` (Double && Double)

  val consumer: Double `=>C` Unit

  lazy val mainSumOfSquares: Unit `=>C` Unit = { u =>
    producer(u) bind { (z, y) =>
      sumOfSquares(z, y) bind { x =>
        consumer(x)
      }
    }
  }

}
```

`trait MainSumOfSquares` defines `lazy val mainSumOfSquares` using abstract members `producer` and `consumer`.

#### **`factorial` as computation**

Below is the code for `factorial`.

```scala
package pdbp.examples.kleisliPrograms

import pdbp.computation.Computation

class Factorial[C[+ _]: Computation]
    extends AtomicKleisliPrograms[C]()
    with HelperKleisliPrograms[C]() {

  import pdbp.computation.bindingOperator._

  val factorial: BigInt `=>C` BigInt = { z =>
    isZero(z) bind { b =>
      if (b) {
        one(z)
      } else {
        subtractOne(z) bind { y =>
          factorial(y) bind { x =>
            multiply((z, x))
          }
        }
      }
    }
  }

}
```

where

```scala
package pdbp.examples.kleisliPrograms
package pdbp.examples.kleisliPrograms

import pdbp.types.product.productType._

import pdbp.computation.Resulting

import pdbp.examples.utils.functionUtils._

trait AtomicKleisliPrograms[C[+ _]: Resulting]
    extends HelperKleisliPrograms[C] {

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val isZero: BigInt `=>C` Boolean = isZeroHelper

  val subtractOne: BigInt `=>C` BigInt = subtractOneHelper

  val multiply: (BigInt && BigInt) `=>C` BigInt = multiplyHelper

  def one[Z]: Z `=>C` BigInt = oneHelper

  // ...

}
```

where

```scala
package pdbp.examples.kleisliPrograms

import pdbp.types.product.productType._

import pdbp.computation.Resulting

import pdbp.examples.utils.functionUtils._

trait HelperKleisliPrograms[C[+ _]: Resulting] {

  import implicitly._

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val isZeroHelper: BigInt `=>C` Boolean = isZeroFunction andThen result

  val subtractOneHelper
    : BigInt `=>C` BigInt = subtractOneFunction andThen result

  val multiplyHelper
    : (BigInt && BigInt) `=>C` BigInt = multiplyFunction andThen result

  def oneHelper[Z]: Z `=>C` BigInt = oneFunction andThen result

  // ...

}
```

where

```scala
package pdbp.examples.utils.functionUtils._

object functionUtils {

  // ...

  val isZeroFunction: BigInt => Boolean = { i =>
    i == 0
  }

  val subtractOneFunction: BigInt => BigInt = { i =>
    i - 1
  }

  val multiplyFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
    i * j
  }

  def oneFunction[Z]: Z => BigInt = { z =>
    1
  }

  // ... 

}
```

Since the atomic kleisli programs , `isZero` and `subtractOne`, `multiply` and `one` used by `factorial` are very fine-grained this gives us a lot of flexibility to give a meaning to `sumOfSquares`.

#### **Describing `mainFactorial` as computation**

Consider

```scala
package pdbp.examples.mainKleisliPrograms

import pdbp.computation.Computation

import pdbp.examples.kleisliPrograms.Factorial

trait MainFactorial[C[+ _]: Computation] {

  import pdbp.computation.bindingOperator._

  private object factorialObject extends Factorial[C]

  import factorialObject.factorial

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val producer: Unit `=>C` BigInt

  val consumer: BigInt `=>C` Unit

  lazy val mainFactorial: Unit `=>C` Unit = { u =>
    producer(u) bind { z =>
      factorial(z) bind { y =>
        consumer(y)
      }
    }
  }

}
```

`trait MainFactorial` defines `lazy val mainFactorial` using abstract members `producer` and `consumer`.

### **Describing `trait Lifting`**

The members `result` and `bind` are the basic members of `trait Computation`.
It turns out that there are many other useful members that can be defined using them.

Consider

```scala
package pdbp.computation

private[pdbp] trait Lifting[C[+ _]]
    extends ObjectLifting[C]
    with FunctionLifting[C]
    with OperatorLifting[C]
```

where

```scala
private[pdbp] trait ObjectLifting[C]

private[pdbp] trait FunctionLifting[C]

private[pdbp] trait OperatorLifting[C]
```

belong to the same `package pdbp.computation`.

`trait Lifting` is a type class that is explained later in this section. 
`trait Lifting` declares the *lifting capabilities* of computations. 

Note that we were a bit sloppy by not showing `[C[+ _]]`.

The lifting capabilities of `Lifting` correspond to *applicatives* (a.k.a. *idioms*).

`trait ObjectLifting`, `trait FunctionLifting` and `trait OperatorLifting` are explained later in this section. 

Note that, again, we were a bit sloppy by not showing `[C]`.

#### **Describing `trait ObjectLifting`**

Consider

```scala
package pdbp.computation

private[pdbp] trait ObjectLifting[C[+ _]] {

  private[pdbp] def liftObject[Z](z: Z): C[Z] =
    lift0(z)

  private[pdbp] def lift0[Z]: Z => C[Z] =
    liftObject

}
```

`liftObject` and it's alias `lift0` are members that *lift* an *object* `z` of type `Z` to a *computation* of type `C[Z]` with result `z`.
The `0` in `lift0` stands for lifting zero parameters.

#### **Describing `trait FunctionLifting`**

Consider

```scala
package pdbp.computation

private[pdbp] trait FunctionLifting[C[+ _]] {

  private[pdbp] def liftFunction[Z, Y](`z=>y`: Z => Y): C[Z] => C[Y] =
    lift1(`z=>y`)

  private[pdbp] def lift1[Z, Y]: (Z => Y) => C[Z] => C[Y] =
    lift1

}
```

`liftFunction` and it's alias `lift1` are members that *lift* an *object-level function* to a *computation-level function*.
The `1` in `lift1` stands for lifting one parameter.

#### **Describing `trait OperatorLifting`**

Consider

```scala
import pdbp.types.product.productType._

private[pdbp] trait OperatorLifting[C[+ _]] {

  private[pdbp] def liftOperator[Z, Y, X](
      `(z&&y)=>x`: (Z && Y) => X): (C[Z] && C[Y]) => C[X] =
    lift2(`(z&&y)=>x`)

  private[pdbp] def lift2[Z, Y, X]: ((Z && Y) => X) => (C[Z] && C[Y]) => C[X] =
    liftOperator

}
```

`liftOperator` and it's alias `lift2` are members that *lift* an *object-level operator* to a *computation-level operator*.
The `2` in `lift2` stands for lifting two parameters.

### **Describing `trait Lifting` revisited**

Consider

```scala
package pdbp.computation

import pdbp.types.product.productType._

import pdbp.utils.productUtils._

private[pdbp] trait Lifting[C[+ _]]
    extends ObjectLifting[C]
    with FunctionLifting[C]
    with OperatorLifting[C] {

  private[pdbp] def lift3[Z, Y, X, W]
    : ((Z && Y && X) => W) => (C[Z] && C[Y] && C[X]) => C[W] =
    `((z&&y)&&x)=>w` =>
      `((cz&&cy)=>c(z&&y)))=>((cz&&cy)&&cx)=>c(z&&y)&&cx`(
        lift2(`(z&&y)=>(z&&y)`)) andThen lift2(`((z&&y)&&x)=>w`)

  // and so on ...

  private[pdbp] def liftedAnd[Z, Y]: (C[Z] && C[Y]) => C[Z && Y] =
    liftOperator(`(z&&y)=>(z&&y)`)

  private[pdbp] def liftedApply[Z, Y]: (C[Z => Y] && C[Z]) => C[Y] =
    liftOperator(`((z=>y)&&z)=>y`)

  private[pdbp] override def lift1[Z, Y]: (Z => Y) => C[Z] => C[Y] = {
    `z=>y` => cz =>
      lift2(`((z=>y)&&z)=>y`)(lift0(`z=>y`), cz)

  }

}
```

Lifting does not stop with objects (`lift0`), unary functions (`lift1`) and binary operators (`lift2`).
It is possible to define `lift3`, for lifting ternary operators and so on ... .

  - `lift3` is defined in terms of `lift2`

where

 - `` `((cz&&cy)=>c(z&&y)))=>((cz&&cy)&&cx)=>c(z&&y)&&cx` ``

is the program you expect.

```scala
package pdbp.utils

// ...

object productUtils {

  // ...

  def `((cz&&cy)=>c(z&&y)))=>((cz&&cy)&&cx)=>c(z&&y)&&cx`[C[+ _], Z, Y, X]
    : (((C[Z] && C[Y]) => C[Z && Y])) => (
        C[Z] && C[Y] && C[X]) => C[Z && Y] && C[X] = {
    `(cz&&cy)=>c(z&&y)` => (`cz&&cy`, cx) =>
      (`(cz&&cy)=>c(z&&y)`(`cz&&cy`), cx)
  }

  // ...     

}
```

`Lifting` comes with some other interesting computational capabilities.

  - `liftedAnd`, defined in terms of `liftOperator`

where

 - `` `(z&&y)=>(z&&y)` ``

is the function you expect.

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

is the function you expect.

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

Note that `lift1` can be defined in terms of `lift0` and `lift2`.


```scala
package pdbp.computation

// ...

private[pdbp] trait Lifting[C[+ _]]
    extends ObjectLifting[C]
    with FunctionLifting[C]
    with OperatorLifting[C] {

  // ...
  
  private[pdbp] override def lift1[Z, Y]: (Z => Y) => C[Z] => C[Y] = {
    `z=>y` => cz =>
      lift2(`((z=>y)&&z)=>y`)(lift0(`z=>y`), cz)

}
```

You may argue why we go for *arrows* (cfr. `Program`) instead of applicatives (cfr. `Lifting`).
Arrows occupy the sweet spot between monads and applcatives as far as power of expression and elegance of use is concerned.

Arrows naturally promote pointfree, composition based programming.
Agreed, applicatives can also be programmed in a pointfree, composition based way.

Arrows can use an elegant `Dotty` programming DSL.

Anyway, applicatives provide less power of expression for application developers.

### **Defining lifting capabilities in terms of computational capabilities**

The lifting capabilities `lift0`, `lift1`, `lift2`, `lift3`, ... , can be defined in terms of the computational capabilities `bind` and `result`.

```scala
package pdbp.computation

import pdbp.types.product.productType._

// ...

private[pdbp] trait Computation[C[+ _]]
    extends Resulting[C]
    with Binding[C]
    with Lifting[C]
    with Sequencing[C]
    with Program[Kleisli[C]] 
    with Applying[Kleisli[C]] {

  override private[pdbp] def lift0[Z]: Z => C[Z] =
    result

  override private[pdbp] def lift1[Z, Y]: (Z => Y) => C[Z] => C[Y] = `z=>y` => {
    case cz =>
      bind(cz, z => result(`z=>y`(z)))
  }

  override private[pdbp] def lift2[Z, Y, X]
    : ((Z && Y) => X) => (C[Z] && C[Y]) => C[X] = `(z&&y)=>x` => {
    case (cz, cy) =>
      bind(cz, z => bind(cy, y => result(`(z&&y)=>x`(z, y))))
  }

  override private[pdbp] def lift3[Z, Y, X, W]
    : ((Z && Y && X) => W) => (C[Z] && C[Y] && C[X]) => C[W] =
    `(z&&y&&x)=>w` => {
      case ((cz, cy), cx) =>
        bind(
          cz,
          z => bind(cy, y => bind(cx, x => result(`(z&&y&&x)=>w`((z, y), x)))))
    }

  // and so on ...

  // ...

}  
```

Note that `result` and `bind` really provide a lot of, agreed, pointful, power of expression for library developers.
Note that the definitions of `lift0`, `lift1`, `lift2`, `lift3`, ... naturally read from left to right.
Finally, note that it suffices to define  `lift0` and `lift1` in terms of `result` and `bind`.

### **Defining programming capabilities in terms of computational capabilities**.

The programming capabilities `function`, `compose`, `product` and `sum` can be defined in terms of the computational capabilities `bind` and `result`.

```scala
package pdbp.computation

// ...

import pdbp.types.sum.sumType._

import pdbp.utils.sumUtils._

// ...

private[pdbp] trait Computation[C[+ _]]
    extends Resulting[C]
    with Binding[C]
    with Lifting[C]
    with Sequencing[C]
    with Program[Kleisli[C]] 
    with Applying[Kleisli[C]] {

  // ...    

  private type `=>C` = Kleisli[C]

  override def function[Z, Y]: (Z => Y) => Z `=>C` Y = { `z=>y` => z =>
    result(`z=>y`(z))
  }

  override def compose[Z, Y, X](`z=>cy`: Z `=>C` Y,
                                `y=>cx`: => Y `=>C` X): Z `=>C` X = { z =>
    bind(`z=>cy`(z), `y=>cx`)
  }

  override def product[Z, Y, X](`z=>cy`: Z `=>C` Y,
                                `z=>cx`: => Z `=>C` X): Z `=>C` (Y && X) = {
    z =>
      bind(`z=>cy`(z), y => bind(`z=>cx`(z), x => result(y, x)))
  }

  override def sum[Z, Y, X](`y=>cz`: => Y `=>C` Z,
                            `x=>cz`: => X `=>C` Z): (Y || X) `=>C` Z =
    foldSum(`y=>cz`, `x=>cz`)

}
```

Again, note that `bind` and `result` really provide a lot of, agreed, pointful, power of expression for library developers.
Also, note that the definitions of `function`, `compose` and `product` naturally read from left to right.

### **Defining computational capabilities in terms of programming and applying capabilities**

#### **Describing `trait Applying`**

Consider 

```scala
package pdbp.program

import pdbp.types.product.productType._

private[pdbp] trait Applying[>-->[- _, + _]] {

  private[pdbp] def apply[Z, Y]: (Z && (Z >--> Y)) >--> Y

}
```

Think of `apply` as a program that *applies* a program of type `Z >--> Y` to an argument of type `Z`.
It transforms the argument of type `Z` to yield a result of type `Y`.

#### **Augmenting computational capabilities with the applying capability**

Computational capabilities can, trivially, be augmented with the applying capability.

```scala
package pdbp.computation

// ...

private[pdbp] trait Computation[C[+ _]]
    extends Resulting[C]
    with Binding[C]
    with Lifting[C]
    with Sequencing[C]
    with Program[Kleisli[C]] 
    with Applying[Kleisli[C]] {

  // ...

  override private[pdbp] def apply[Z, Y]: (Z && (Z `=>C` Y)) `=>C` Y = {
    (z, `z=>cy`) =>
      `z=>cy`(z)
  }   

}
```

#### **Introducing `type Kleisli` for unary type constructors**

Consider

```scala
package pdbp.types.kleisli

object kleisliUnaryTypeConstructorType {

  type Kleisli[>-->[- _, + _]] = [+Y] => Unit >--> Y

}
```

A computation of type `Kleisli[>-->]` is referred to as a *kleisli computation*. 
Think of it as a program without arguments.

The computational capabilities `result` and `bind` can be defined in terms the of the programming capabilities `function`, `compose`, and `product` together with the applying capability `apply`.

```scala
package pdbp.program

import pdbp.program.Program
import pdbp.program.Applying

import pdbp.computation.Resulting
import pdbp.computation.Binding

import pdbp.types.kleisli.kleisliUnaryTypeConstructorType._

private[pdbp] trait ProgramWithApplying[>-->[- _, + _]]
    extends Program[>-->]
    with Applying[>-->]
    with Resulting[Kleisli[>-->]]
    with Binding[Kleisli[>-->]] {

  private type C = Kleisli[>-->]

  override private[pdbp] def result[Z]: Z => C[Z] =
    `z=>(u>-->z)`

  override private[pdbp] def bind[Z, Y](cz: C[Z], `z=>cy`: => Z => C[Y]): C[Y] =
    compose(cz, compose(product(`z>-->u`, function(`z=>cy`)), apply))

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

## **Semantics of Program Descriptions**

Programs are *defined* as members of `class`es that are *declared* to *implicitly* have the *declared* programming capabilities of `trait Program[>-->[- _, + _]]`.

Think of programs as *programming domain specific, library language level, syntactic constructs*.

We also refer to programs as *syntactic program descriptions*.

There is no *semantics* associated with them.

### **Program Implementations**

Below are the first steps towards associating semantics with syntactic program descriptions.

 - *Define* the programming capabilities of type class `trait Program[>-->[+ _, - _]]` in `implicit object`'s that `extend trait Program[>-->[+ _, - _]]`. 
 - *Implement* programs by defining `object`'s, *depending* on those `implicit object`'s, that extend the `class`es the programs are defined in as members. 

We also refer to an `implicit object` that is defined as above as an *implicit program object*.
We also refer to a program that is implemented as above as a *program implementation*.

Program implementations depend on implicit program objects using *dependency injection* by `import`.
This is an example of a very common *design pattern* for type clases.

Note that defining the computational capabilities of type class `trait Computation[C[+ _]]` in `implicit object`'s that `extends trait trait Computation[C[+ _]]` also defines the programming capabilities of `trait Program[Kleisli[C]]`.

We also refer to an `implicit object` that is defined as above as an *implicit computation object* or *implicit kleisli program object*.
We also refer to a kleisli program that is implemented as above as a *kleisli program implementation*.

### **Describing `activeProgram`**

The simplest implicit computation object (and corresponding implicit kleisli program object) one can probably think of is the *active* one defined below

```scala
package pdbp.program.implicits.active

import pdbp.types.active.activeTypes._

import pdbp.utils.functionUtils._

import pdbp.program.Program

import pdbp.computation.Computation

object implicits {

  implicit object activeProgram
      extends Computation[Active]
      with Program[`=>A`] {

    override private[pdbp] def result[Z]: Z => Active[Z] = `z=>az`

    override private[pdbp] def bind[Z, Y](
        az: Active[Z],
        `z=>ay`: => (Z => Active[Y])): Active[Y] =
      `z=>ay`(az)

    override def compose[Z, Y, X](`z=>ay`: Z `=>A` Y,
                                  `y=>ax`: => Y `=>A` X): Z `=>A` X = { z =>
      bind(`z=>ay`(z), `y=>ax`)
    }

  }

}
```

where the types `Active` and `` `=>A` `` are defined as follows

```scala
package pdbp.types.active

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

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

Note that we use *active* as opposed to *reactive* that we deal with later in this document.

For the `activeProgram` implicit program object we could already go ahead and *run* programs.

For other implicit program object we need more machinery.

## **Natural transformations**

Note that `>-->[- _, + _]` resp. `C[+ _]` are *binary* resp. *unary* *type constructors*.

Such type constructors can be *transformed* using *natural transformations*. 

### **Natural binary type constructor transformations**

Consider

```scala
package pdbp.natural.transformation.binary

trait `~B~>`[`>-F->`[- _, + _], `>-T->`[- _, + _]] {

  def apply[Z, Y]: Z `>-F->` Y => Z `>-T->` Y

}
```

`` trait `~B~>` `` defines *natural binary type constructor transformations*.
`F` stands for from, `T` stands for to, and `B` stands for binary.


### **Natural unary type constructor transformations**

Consider

```scala
package pdbp.natural.transformation.unary

private[pdbp] trait `~U~>`[F[+ _], T[+ _]]
    extends `~B~>`[Kleisli[F], Kleisli[T]] {
  `f~u~t1` =>

  private[pdbp] def apply[Z](fz: F[Z]): T[Z]

  type T1 = T

  private[pdbp] def andThen[T2[+ _]](`t1~u~t2`: T1 `~U~>` T2): F `~U~>` T2 =
    new {
      override private[pdbp] def apply[Z](fz: F[Z]): T2[Z] =
        `t1~u~t2`(`f~u~t1`(fz))
    } 

  // ...

}
```

`` trait `~U~>` `` defines *natural unary type constructor transformations*.
`F` stands for from, `T` stands for to, and `U` stands for unary.

Natural unary type constructor transformations are similar to functions 
 - they have an`apply` member, so that they can be *applied*,
 - they have an `andThen` member, so that they can be *composed*.

The difference with functions is that they work at the unary type constructor level instead of at the type level.

### **Defining natural binary type constructor transformations in terms of natural unary type constructor transformations**

For kleisli binary type constructor types, natural binary type constructor transformations can be defined in terms of natural unary type constructor transformations.

```scala
import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.natural.transformation.binary.`~B~>`

private[pdbp] trait `~U~>`[F[+ _], T[+ _]]
    extends `~B~>`[Kleisli[F], Kleisli[T]] {
  `f~u~t` =>

  // ...

  private type `=>F` = Kleisli[F]

  private type `=>T` = Kleisli[T]

  override def apply[Z, Y]: Z `=>F` Y => Z `=>T` Y = { `z=>fy` =>
    `z=>fy` andThen apply
  }

}
```

### **Describing `ProgramMeaning`**

```scala
package pdbp.program.meaning

import pdbp.program.Program

import pdbp.natural.transformation.binary.`~B~>`

private[pdbp] trait ProgramMeaning[
    `>-FP->`[- _, + _]: Program, `>-T->`[- _, + _]] {

  private[pdbp] lazy val binaryTransformation: `>-FP->` `~B~>` `>-T->`

  lazy val meaning: `>-FP->` `~B~>` `>-T->` = binaryTransformation

}
```

`trait ProgramMeaning` has one `public` member, `meaning` that is a natural binary type constructor transformation that is an alias for a `private[pdbp]` member, `binaryTransformation`.

We refer to the `meaning` member of `trait ProgramMeaning`  as a *program meaning*.

### **Describing `ComputationMeaning`**

```scala
package pdbp.computation.meaning

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.natural.transformation.binary.`~B~>`

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.Computation

import pdbp.program.meaning.ProgramMeaning

private[pdbp] trait ComputationMeaning[FC[+ _]: Computation, T[+ _]]
    extends ProgramMeaning[Kleisli[FC], Kleisli[T]] {

  private[pdbp] val unaryTransformation: FC `~U~>` T

  // ...

}
```
`trait ComputationMeaning` has one `private[pdbp]` member, `unaryTransformation`. that is a natural binary type constructor transformation that is a natural unary type constructor transformation.

We refer to the `unaryTransformation` member of `trait ComputationMeaning`  as a *computation meaning*.


### **Defining program meanings in terms of computation meanings**

For kleisli programs, program meanings can be defined in terms of computation meanings.

We refer to program meanings of kleisli programs as kleisli program meanings.

```scala
private[pdbp] trait ComputationMeaning[FC[+ _]: Computation, T[+ _]]
    extends ProgramMeaning[Kleisli[FC], Kleisli[T]] {

  // ...    

  private type `=>FC` = Kleisli[FC]

  private type `=>T` = Kleisli[T]

  private[pdbp] override lazy val binaryTransformation: `=>FC` `~B~>` `=>T` =
    unaryTransformation

}
```

### **Program Meanings**

Below are the last steps towards associating semantics with syntactic program descriptions.

 - *Define* the `meaning` member of `trait ProgramMeaning` in `object`'s that `extend trait ProgramMeaning`. 
 - *Use* program meanings to naturally transform program implementations.
   
Although. since `trait ProgramMeaning` is not a type class, it is not necessary to define `implicit object`'s it is convenient to do so. 

### **Describing `activeMeaningOfActive`**

The simplest computation meaning (and corresponding kleisli program meaning) one can probably think of is the *active meaning of active* one defined below

```scala
package pdbp.program.meaning.ofActive.active

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits.activeProgram

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.ofActive.MeaningOfActive

object implicits {

  implicit object activeMeaningOfActive
      extends MeaningOfActive[Active]()
      with ComputationMeaning[Active, Active]()
      with ProgramMeaning[`=>A`, `=>A`]()

}
```

where `MeaningOfActive` defines a computation meaning of `Active` for any type constructor `TR` that is declared to implicitly have the `Resulting` computational capability.

```scala
package pdbp.computation.meaning.ofActive

import pdbp.types.active.activeTypes._

import pdbp.computation.Resulting

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.meaning.ComputationMeaning

private[pdbp] trait MeaningOfActive[TR[+ _]: Resulting]
    extends ComputationMeaning[Active, TR] {

  override private[pdbp] val unaryTransformation: Active `~U~>` TR =
    new {
      override private[pdbp] def apply[Z](az: Active[Z]): TR[Z] = {
        import implicitly._
        result(az)
      }
    }

}
```

## **Running main programs**

### **Running `mainFactorial` using `activeProgram`, `effectfulReadIntFromConsole` and `effectfulWriteFactorialOfIntToConsole`**

Consider

```scala
package examples.main.active.effectfulReadingAndWriting

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits.activeProgram

import examples.mainPrograms.MainFactorial

object FactorialMain extends MainFactorial[`=>A`]() {

  import examples.utils.EffectfulUtils

  private val effectfulUtils = new EffectfulUtils[`=>A`]

  import effectfulUtils._

  override val producer = effectfulReadIntFromConsole

  override val consumer = effectfulWriteFactorialOfIntToConsole

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive.meaning

    meaning(mainFactorial)(())

  }

}
```

The definition of `object FactorialMain` uses dependency injection by `import` of `implicit object activeProgram` that extends `` Program[`=>A`]  ``.
Here are some details

  - `object FactorialMain` extends `` trait `MainFactorial[`=>A`] ``,
  - `` trait `MainFactorial[`=>A`]` `` has an `object` member `factorialObject` that extends `` `Factorial[`=>A`] ``,
  - `factorialObject` has a `val` member `factorial` that is a program implementation of type `` BigInt `=>A` BigInt ``,
  - `` trait `MainFactorial[`=>A`]` `` has a `lazy val` member `mainFactorial` that is a main program implementation of type `` Unit `=>A` Unit `` that  uses members `effectfulReadIntFromConsole` resp. `effectfulWriteFactorialOfIntToConsole` from `class EffectUtils` to define `producer` resp. `consumer` of `trait `MainFactorial[>-->]`.

```scala
package examples.utils

import pdbp.program.Program

import pdbp.utils.effectfulUtils._

class EffectfulUtils[>-->[- _, + _]: Program] {

  import implicitly._

  private def effectfulReadIntFromConsoleWithMessage(
      message: String): Unit >--> BigInt =
    function(effectfulReadIntFromConsoleFunction(message))

  private def effectfulWriteLineToConsoleWithMessage[Y](
      message: String): Y >--> Unit =
    function[Y, Unit](effectfulWriteLineToConsoleFunction(message))

  val effectfulReadIntFromConsole: Unit >--> BigInt =
    effectfulReadIntFromConsoleWithMessage("please type an integer")

  val effectfulWriteFactorialOfIntToConsole: BigInt >--> Unit =
    effectfulWriteLineToConsoleWithMessage(
      "the factorial value of the integer is")

  // ...

}
```

where

```scala
package pdbp.utils

import scala.io.StdIn.{readInt, readDouble}

import pdbp.types.product.productType._

object effectfulUtils {

  def effectfulReadIntFromConsoleFunction(message: String): Unit => BigInt = {
    _ =>
      println(s"$message")
      val i = BigInt(readInt())
      i
  }

  // ...

  def effectfulWriteLineToConsoleFunction[Y](message: String): Y => Unit = {
    y =>
      println(s"$message")
      val u = println(s"$y")
      u
  }

  // ...

}
```

The definition of `object FactorialMain` uses `activeMeaningOfActive.meaning` to transform the main program implementation `mainFactorial`.

Note that, since `meaning(mainFactorial)` has

  - type `` Unit `=>A` Unit ``, which is
  - type `Unit => Active[Unit]`, which is
  - type `Unit => Unit`

it suffices to evaluate `meaning(mainFactorial)(())`.

Let's try running `factorial` with `10`.

```scala
[info] Running examples.main.active.effectfulReadingAndWriting.FactorialMain
please type an integer
10
the factorial value of the integer is
3628800
```

Let's try running `factorial` with `100`.

```scala
[info] Running examples.main.active.effectfulReadingAndWriting.FactorialMain
please type an integer
100
the factorial value of the integer is
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
```

Let's try running `factorial` with `1000`.

```scala
[info] Running examples.main.active.effectfulReadingAndWriting.FactorialMain
please type an integer
1000
[error] (run-main-0) java.lang.StackOverflowError
java.lang.StackOverflowError
```

We have a problem. 

The semantics of the syntactic `factorial` program description uses the *stack* and is *not stack safe*. 
  - the stack overflows for the argument `1000`.
 
The good news is that it is just one semantics of that syntactic program description.

The semantics of the syntactic `factorial` program description can be replaced by a *stack safe* one that uses the *heap*. 
  - the heap does not run out of memory for the argument `1000`.

We have another problem.

We promised to use `function` only for *pure* (a.k.a. as *effectfree*) functions.
Both `effectfulReadIntFromConsole` and `effectfulWriteFactorialOfIntToConsole` are programs that *execute effects* in an *impure* (a.k.a. as *effectful*) way.

Both `effectfulReadIntFromConsole` and `effectfulWriteFactorialOfIntToConsole` can be replaced by programs that *describe effects* in an pure (a.k.a *effectfree*) way.

### **Running `mainFactorial` computation using `activeProgram`, `effectfulReadIntFromConsole` and `effectfulWriteFactorialOfIntToConsole`**

Consider

```scala
package pdbp.examples.main.active.effectfulReadingAndWriting

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits.activeProgram

import pdbp.examples.mainKleisliPrograms.MainFactorial

import pdbp.examples.utils.EffectfulUtils

object FactorialMain
    extends MainFactorial[Active]()
    with EffectfulUtils[Active]() {

  override val producer = effectfulReadIntFromConsole

  override val consumer = effectfulWriteFactorialOfIntToConsole

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive.meaning

    meaning(mainFactorial)(())

  }

}
```

where

```scala
package pdbp.examples.utils

import pdbp.types.product.productType._

import pdbp.utils.effectfulUtils._

import pdbp.computation.Resulting

trait EffectfulUtils[C[+ _]: Resulting] {

  import implicitly._

  type `=>C` = [-Z, +Y] => Z => C[Y]

  private def effectfulReadIntFromConsoleWithMessage(
      message: String): Unit `=>C` BigInt = { _ =>
    result(effectfulReadIntFromConsoleFunction(message)(()))
  }

  // ...

  private def effectfulWriteLineToConsoleWithMessage[Y](
      message: String): Y `=>C` Unit = { y =>
    result(effectfulWriteLineToConsoleFunction(message)(y))
  }

  val effectfulReadIntFromConsole: Unit `=>C` BigInt =
    effectfulReadIntFromConsoleWithMessage("please type an integer")

  // ...

  val effectfulWriteFactorialOfIntToConsole: BigInt `=>C` Unit =
    effectfulWriteLineToConsoleWithMessage(
      "the factorial value of the integer is")

  // ...

}
```

Let's try running `factorial` with `10`.

```scala
[info] Running pdbp.examples.main.active.effectfulReadingAndWriting.FactorialMain
please type an integer
10
the factorial value of the integer is
3628800
```

Let's try running `factorial` with `100`.

```scala
[info] Running pdbp.examples.main.active.effectfulReadingAndWriting.FactorialMain
please type an integer
100
the factorial value of the integer is
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
```


### **Running `mainSumOfSquares` computation using `activeProgram`, `effectfulReadIntFromConsole` and `effectfulWriteSumOfSquaresOfTwoDoublesToConsole`**

Consider

```scala
package pdbp.examples.main.active.effectfulReadingAndWriting

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits.activeProgram

import pdbp.examples.mainKleisliPrograms.MainSumOfSquares

import pdbp.examples.utils.EffectfulUtils

object SumOfSquaresMain
    extends MainSumOfSquares[Active]()
    with EffectfulUtils[Active]() {

  override val producer = effectfulReadTwoDoublesFromConsole

  override val consumer = effectfulWriteSumOfSquaresOfTwoDoublesToConsole

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive.meaning

    meaning(mainSumOfSquares)(())

  }

}
```

where

```scala
package pdbp.examples.utils

import pdbp.types.product.productType._

import pdbp.utils.effectfulUtils._

import pdbp.computation.Resulting

trait EffectfulUtils[C[+ _]: Resulting] {

  import implicitly._

  type `=>C` = [-Z, +Y] => Z => C[Y]

  // ...

  private def effectfulReadTwoDoublesFromConsoleWithMessage(
      message: String): Unit `=>C` (Double && Double) = { _ =>
    result(effectfulReadTwoDoublesFromConsoleFunction(message)(()))
  }

  private def effectfulWriteLineToConsoleWithMessage[Y](
      message: String): Y `=>C` Unit = { y =>
    result(effectfulWriteLineToConsoleFunction(message)(y))
  }

  // ...

  val effectfulReadTwoDoublesFromConsole: Unit `=>C` (Double && Double) =
    effectfulReadTwoDoublesFromConsoleWithMessage("please type a double")

  // ...

  val effectfulWriteSumOfSquaresOfTwoDoublesToConsole: Double `=>C` Unit =
    effectfulWriteLineToConsoleWithMessage(
      "the sum of the squares of the doubles is")

}
```

where

```scala
package pdbp.utils

import scala.io.StdIn.{readInt, readDouble}

import pdbp.types.product.productType._

object effectfulUtils {

  // ...

  def effectfulReadTwoDoublesFromConsoleFunction(
      message: String): Unit => (Double && Double) = { _ =>
    println(s"$message")
    val d1 = readDouble()
    println(s"$message")
    val d2 = readDouble()
    (d1, d2)
  }

  def effectfulWriteLineToConsoleFunction[Y](message: String): Y => Unit = {
    y =>
      println(s"$message")
      val u = println(s"$y")
      u
  }

  // ...

}
```

Let's try running `sumOfSquares` with `3.0` and `4.0`.

```scala
[info] Running pdbp.examples.main.active.effectfulReadingAndWriting.SumOfSquaresMain
please type a double
3.0
please type a double
4.0
the sum of the squares of the doubles is
25.0
```

## **Describing `ComputationTransformation`**

*Computation transformations* are defined using natural unary type constructor transformations as follows

```scala
import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.program.Program

import pdbp.computation.Computation

private[pdbp] trait ComputationTransformation[FC[+ _]: Computation, T[+ _]]
    extends Computation[T]
    with Program[Kleisli[T]] {

  private[pdbp] val transform: FC `~U~>` T

}
```

Computation transformations closely resemble *monad transformers*.

Monad transformers were introduced in [Monad Transformers and Modular Interpreters](http://haskell.cs.yale.edu/wp-content/uploads/2011/02/POPL96-Modular-interpreters.pdf). 

I have contributed to monad transformers myself by combining them with *catamorpisms* in [Using Catamorphisms, Subtypes and Monad Transformers for Writing Modular Functional Interpreters](http://citeseerx.ist.psu.edu/viewdoc/download;jsessionid=97555A49D9F56885C9EA225088EA73BA?doi=10.1.1.11.7093&rep=rep1&type=pdf).

### **Describing `FreeTransformation`**

The first computation transformer that we describe is `trait FreeTransformation`.

```scala
package pdbp.computation.transformation.free

import FreeTransformation._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait FreeTransformation[FC[+ _]: Computation]
    extends ComputationTransformation[FC, FreeTransformed[FC]] {

  private type FTFC = FreeTransformed[FC]

  override private[pdbp] val transform: FC `~U~>` FTFC = new {
    override private[pdbp] def apply[Z](fcz: FC[Z]): FTFC[Z] =
      Transform(fcz)
  }

  override private[pdbp] def result[Z]: Z => FTFC[Z] = { z =>
    Result(z)
  }

  override private[pdbp] def bind[Z, Y](
      ftfcz: FTFC[Z],
      `z=>ftfcy`: => (Z => FTFC[Y])): FTFC[Y] =
    Bind(ftfcz, `z=>ftfcy`)

}
```

where

```scala
private[pdbp] object FreeTransformation {

  sealed trait Free[C[+ _], +Z]

  final case class Transform[C[+ _], +Z](cz: C[Z]) extends Free[C, Z]
  final case class Result[C[+ _], +Z](z: Z) extends Free[C, Z]
  final case class Bind[C[+ _], -Z, ZZ <: Z, +Y](fczz: Free[C, ZZ],
                                                 `z=>fcy`: Z => Free[C, Y])
      extends Free[C, Y]

  private[pdbp] type FreeTransformed[C[+ _]] = [+Z] => Free[C, Z]

}
```

`trait Free` is an *abstract data type* that is a

  - `case class Transform`

corresponding to the member `transform` of `trait ComputationTransformation`,

or is a

  - `case class Result`, or a
  - `case class Bind` 

corresponding to the members `result` and `bind` of `trait Computation`.

Think of `FreeTransformed[C]` `objects`'s as *free transformed computations*. 

`trait FreeTransformation` transforms 

  - a computation `C` to a computation `FreeTransformed[C]`,
  - the corresponding kleisli program `Kleisli[C]` to a kleisli program `Kleisli[FreeTransformed[C]]`. 

The definitions of `transform`, `result` and `bind` are trivial.
They construct a data structure on the heap.

 - `transform` constructs a `Transform`,
 - `result` constructs a `Result`,
 - `bind` constructs a `Bind`.

Think of `Free[C, Z]` as a *free data type* wrapped around `C` as described in [Data types a la carte](http://www.cs.ru.nl/~W.Swierstra/Publications/DataTypesALaCarte.pdf).

The data structure built using `Transform` wraps the computational capabilities of a computation `cz` of type `C[Z]` by transforming them to *suspended* capabilities of type `Free[C, Z]`.

The data structures built using `Result` and `Bind` can be seen as a *free program implementation* for the computational capabilities `result` and `bind` of `trait Computation`. In a way it is the most free implementation one can think of because there are no constraints involved. Anyway, it *is* an implementation, it is *not* a description.

### **Describing `activeFreeProgram`**

The next implicit computation object (and corresponding implicit kleisli program object) is the *active free* one defined below

```scala
package pdbp.program.implicits.active.free

import pdbp.types.active.activeTypes._
import pdbp.types.active.free.activeFreeTypes._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.free.FreeTransformation

import pdbp.program.implicits.active.implicits.activeProgram

object implicits {
  
  implicit object activeFreeProgram
      extends Computation[ActiveFree]
      with Program[`=>AF`]
      with FreeTransformation[Active]()
      with ComputationTransformation[Active, ActiveFree]()

}
```

where the types `ActiveFree` and `` `=>AF` `` are defined as follows

```scala
package pdbp.types.active.free

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.types.active.activeTypes._

import pdbp.computation.transformation.free.FreeTransformation._

object activeFreeTypes {

  type ActiveFree = FreeTransformed[Active]

  type `=>AF` = Kleisli[ActiveFree]

}
```

### **Describing `FreeTransformedMeaning`**

The transformed computation meaning corresponding to the free computation transformation `trait FreeTransformation` is `trait FreeTransformedMeaning`.

```scala
package pdbp.computation.meaning.free

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.free.FreeTransformation
import pdbp.computation.transformation.free.FreeTransformation._

import pdbp.computation.meaning.ComputationMeaning

private[pdbp] trait FreeTransformedMeaning[FC[+ _]: Computation, T[+ _]](
    implicit toBeTransformedMeaning: ComputationMeaning[FC, T])
    extends ComputationMeaning[FreeTransformed[FC], T] {

  private val implicitComputation = implicitly[Computation[FC]]

  import implicitComputation._

  private type FTFC = FreeTransformed[FC]

  private val foldingUnaryTransformation: FTFC `~U~>` FC =
    new {
      @annotation.tailrec
      override private[pdbp] def apply[Z](ftfcz: FTFC[Z]): FC[Z] = ftfcz match {
        case Transform(fcz) =>
          fcz
        case Result(z) =>
          result(z)
        case Bind(Result(y), y2ftfcz) =>
          apply(y2ftfcz(y))
        case Bind(Bind(fcx, x2ftfcy), y2ftfcz) =>
          apply(Bind(fcx, { x =>
            Bind(x2ftfcy(x), y2ftfcz)
          }))
        case any =>
          sys.error("Impossible, since, 'apply' eliminates this case")
      }
    }

  override private[pdbp] val unaryTransformation: FTFC `~U~>` T =
    foldingUnaryTransformation andThen toBeTransformedMeaning.unaryTransformation

}
```

Note that in `FTFC`, resp. `ftfc`
  - the first `F`, resp `f` stands for *free* (and `T` resp `t` stands for *transformed*)
  - the second `F`, resp `f` stands for *from* (and `C` resp `c` stands for *computation*)

Note that, for pattern matching, we use names like `y2ftfcz` instead of `` `y=>ftfcz` ``.

The method `apply` that is used in the definition of `foldingUnaryTransformation` is a *tail recursive folding* of a computation of type `FTFC[Z]`, which is a free data structure wrapping a computation of type `FC[Z]`, back to a computation of type `FC[Z]`. 

Note that the last `case` for `Bind` uses an *associativity* law of `bind`.
The *left* associated `Bind`'s are folded to *right* associated `Bind`'s. 

The natural unary type transformation `unaryTransformation` defining `meaning` can be defined as a composition of `foldingUnaryTransformation` and `toBeTransformedMeaning.unaryTransformation`.

### **Describing `activeMeaningOfActiveFree`**

The next computation meaning `implicit object` (and corresponding kleisli program meaning `implicit object`) is the *active meaning of active free* one defined below

```scala
package pdbp.program.meaning.ofActiveFree.active

import pdbp.types.active.activeTypes._
import pdbp.types.active.free.activeFreeTypes._

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.free.FreeTransformedMeaning

import pdbp.program.implicits.active.implicits.activeProgram
import pdbp.program.implicits.active.free.implicits.activeFreeProgram

object implicits {

  import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive

  implicit object activeMeaningOfActiveFree
      extends FreeTransformedMeaning[Active, Active]()
      with ComputationMeaning[ActiveFree, Active]()
      with ProgramMeaning[`=>AF`, `=>A`]()
      
}
```

### **Running `mainFactorial` using `activeFreeProgram` and `activeMeaningOfActiveFree`, and `effectfulReadIntFromConsole` and `effectfulWriteFactorialOfIntToConsole`**

Consider

```scala
package examples.main.active.free.effectfulReadingAndWriting

import pdbp.types.active.free.activeFreeTypes._

import pdbp.program.implicits.active.free.implicits.activeFreeProgram

import examples.mainPrograms.MainFactorial

object FactorialMain extends MainFactorial[`=>AF`]() {

  import examples.utils.EffectfulUtils

  private val effectfulUtils = new EffectfulUtils[`=>AF`]

  import effectfulUtils._

  override val producer = effectfulReadIntFromConsole

  override val consumer = effectfulWriteFactorialOfIntToConsole

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActiveFree.active.implicits.activeMeaningOfActiveFree.meaning

    meaning(mainFactorial)(())

  }

}
```

Note that we only changed a the type `` `=>A`  `` to `` `=>AF` `` and the `import`s `implicits.activeProgram` resp. `activeMeaningOfActive.meaning` to `implicits.activeFreeProgram` resp, `activeMeaningOfActiveFree.meaning` 

Let's try running `factorial` with `1000`.

```scala
[info] Running examples.main.active.free.effectfulReadingAndWriting.FactorialMain
please type an integer
1000
the factorial value of the integer is
402387260077093773543702433923003985719374864210714632543799910429938512398629020592044208486969404800479988610197196058631666872994808558901323829669944590997424504087073759918823627727188732519779505950995276120874975462497043601418278094646496291056393887437886487337119181045825783647849977012476632889835955735432513185323958463075557409114262417474349347553428646576611667797396668820291207379143853719588249808126867838374559731746136085379534524221586593201928090878297308431392844403281231558611036976801357304216168747609675871348312025478589320767169132448426236131412508780208000261683151027341827977704784635868170164365024153691398281264810213092761244896359928705114964975419909342221566832572080821333186116811553615836546984046708975602900950537616475847728421889679646244945160765353408198901385442487984959953319101723355556602139450399736280750137837615307127761926849034352625200015888535147331611702103968175921510907788019393178114194545257223865541461062892187960223838971476088506276862967146674697562911234082439208160153780889893964518263243671616762179168909779911903754031274622289988005195444414282012187361745992642956581746628302955570299024324153181617210465832036786906117260158783520751516284225540265170483304226143974286933061690897968482590125458327168226458066526769958652682272807075781391858178889652208164348344825993266043367660176999612831860788386150279465955131156552036093988180612138558600301435694527224206344631797460594682573103790084024432438465657245014402821885252470935190620929023136493273497565513958720559654228749774011413346962715422845862377387538230483865688976461927383814900140767310446640259899490222221765904339901886018566526485061799702356193897017860040811889729918311021171229845901641921068884387121855646124960798722908519296819372388642614839657382291123125024186649353143970137428531926649875337218940694281434118520158014123344828015051399694290153483077644569099073152433278288269864602789864321139083506217095002597389863554277196742822248757586765752344220207573630569498825087968928162753848863396909959826280956121450994871701244516461260379029309120889086942028510640182154399457156805941872748998094254742173582401063677404595741785160829230135358081840096996372524230560855903700624271243416909004153690105933983835777939410970027753472000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
```

We do not have a stack overflow problem here any more since we are using the heap instead.
Agreed, the heap can run out of memory, but that's another problem.

## **Describing `Reading`**

### **Introduction**

In sections `Program` and `Computation` we presented the *basic* programming and computation capabilities. 

In this section we introduce the first *extra* programming capability: *reading*. 

We already used effectful input reading using *producers* of type `Unit >--> Z` together with effectful output writing using *consumers* of type `Y >--> Unit` to turn programs of type `Z >--> Y` into main programs of type `Unit >--> Unit`. 

In this section we describe *effectfree input reading* of type `Unit >--> R` and, more generally, *effectfree reading* of type `Z >--> R`. 

Think, for example, of the effectfree reading capability of this section as being able to 
  - read *configuration*

### **Describing `Reading`**

Consider

```scala
package pdbp.program.reading

import pdbp.program.Function
import pdbp.program.Composition

trait Reading[R, >-->[- _, + _]] {
  this: Function[>-->] & Composition[>-->] =>

  private[pdbp] def `u>-->r`: Unit >--> R = read[Unit]

  private[pdbp] def `z>-->r`[Z]: Z >--> R =
    compose(`z>-->u`, `u>-->r`)

  def read[Z]: Z >--> R = `z>-->r`

}
```

Think of `` `u>-->r` `` as a zero-argument program that yields result of type `R`.
We also say that `` `u>-->r` `` is a program that, out of the blue, produces a result of type `R`. 
  
Think of `` `z>-->r` `` as a program that transforms any argument of type `Z` to a yield result of type `R`.
We also say that `` `z>-->r` `` is a program that, out of anything, produces a result of type `R`. 

We also simply say that `` `u>-->r` `` and `` `z>-->r` `` *read a value of type* `R`. 

Note that `` `z>-->u` `` and `` `z>-->r` `` are `private[pdbp]`.

Since we are defining a public programming API, it is also convenient to define an `public` alias `read` for `` `z>-->r` ``.

## **Describing `ReadingTransformation`**

The next computation transformer that we describe is `trait ReadingTransformer` that is used to add the *reading* capability to program descriptions.
Groundbraking work by Martin Odersky, [Simplicity](https://infoscience.epfl.ch/record/229878/files/simplicitly_1.pdf), introduces *implicit functions*. 
In his POPL article, Martin Odersky argues that implicit functions can be used to replace the reader monad (cfr. our reading capability of program descriptions). 
Since our goal is to provide an *explicit* program description DSL we add reading as an *explicit* programming capability taking advantage of implicit functions to greatly simplify the definitions of `trait ReadingTransformation` and their performance.

Implicit functions replace boilerplate repetition of `implicit` parameters by an *implicitly* available global value `implicitly`. 
You may argue that this is *going back to the past* since, for years, using globals has been considered to be harmful. 
In fact, instead it is *going back to the future* since the global value `implicitly` is only available in bodies of members having a *type* that *reflects* its *availability*.

Our explicit, globally available, reading capability `read` closely corresponds to the implicit, globally available value `implicitly`.

You may argue: why using an explicit `read` member if using an implicitly available `implicitly` value works as well.

We do not have a fully satisfying answer. The best one we can think of is that we prefer to be explicit at the syntactic level and implicit at the semantics level.

### **Introducing `type` `` `I=>` ``**

Implicit function types `implicit Z => Y` are types like all other ones.

It is convenient to introduce a type alias for them.

```scala
package pdbp.types

object implicitFunctionType {

  type `I=>`[-Z, +Y] = implicit Z => Y

}
```

so that we can write `` Z `I=>` Y ``.

### **Describing `ReadingTransformation`**

Consider

```scala
package pdbp.computation.transformation.reading

import pdbp.types.implicitFunctionType.`I=>`

private[pdbp] object ReadingTransformation {

  private[pdbp] type ReadingTransformed[R, FC[+ _]] = [+Z] => R `I=>` FC[Z]

}

import ReadingTransformation._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.program.reading.Reading

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait ReadingTransformation[R, FC[+ _]: Computation]
    extends ComputationTransformation[FC, ReadingTransformed[R, FC]]
    with Reading[R, Kleisli[ReadingTransformed[R, FC]]] {

  private type RTFC = ReadingTransformed[R, FC]
  private type `=>RTFC` = Kleisli[RTFC]

  import implicitly.{result => resultFC}
  import implicitly.{bind => bindFC}

  override private[pdbp] val transform: FC `~U~>` RTFC = new {
    override private[pdbp] def apply[Z](fcz: FC[Z]): RTFC[Z] =
      fcz
  }

  override private[pdbp] def result[Z]: Z => RTFC[Z] = { z =>
    resultFC(z)
  }  

  override private[pdbp] def bind[Z, Y](
      rtfcz: RTFC[Z],
      `z>=rtfcy`: => (Z => RTFC[Y])): RTFC[Y] =
    bindFC(rtfcz, `z>=rtfcy`(_))

  private[pdbp] override def `u>-->r`: Unit `=>RTFC` R = { _ =>
    resultFC(implicitly)
  }

}
```

where

```scala
import pdbp.types.implicitFunctionType.`I=>`

private[pdbp] object ReadingTransformation {

  type ReadingTransformed[R, FC[+ _]] = [+Z] => R `I=>` FC[Z]

}
```

The types `RTFC` and `` `=>RTFC` ``, defined using `` `I=>` ``, indicate that the an implicitly available global value `implicitly[R]` is available. 
In fact, in `` `u>-->r` `` we use it as `implicitly` (not to be confused with the other `implicitly` standing for `implicitly[Computation[FC]]`). 

You may wonder how on earth it is possible that the definitions above are so simple. 
The magic of implicit function types is that the compiler can turn value types into implicit function types whenever it *expects* them to be.

###  **Describing `activeIntReadingProgram`**

The next implicit computation object (and corresponding implicit kleisli program object) is the *active int reading* one defined below

```scala
package pdbp.program.implicits.active.reading.int

import pdbp.types.active.activeTypes._
import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.implicits.active.reading.ActiveReadingProgram

import pdbp.program.implicits.active.implicits.activeProgram

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

object implicits {

  implicit object activeIntReadingProgram
      extends ActiveReadingProgram[BigInt]()
      with Computation[ActiveReading[BigInt]]()
      with Program[`=>AR`[BigInt]]()
      with Reading[BigInt, `=>AR`[BigInt]]()
      with ReadingTransformation[BigInt, Active]()
      with ComputationTransformation[Active, ActiveReading[BigInt]]()

}
```

where

```scala
package pdbp.program.implicits.active.reading

import pdbp.types.active.activeTypes._
import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.Program
import pdbp.program.reading.Reading

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

private[pdbp] trait ActiveReadingProgram[R]
    extends Computation[ActiveReading[R]]
    with Program[`=>AR`[R]]
    with Reading[R, `=>AR`[R]]
    with ComputationTransformation[Active, ActiveReading[R]]
    with ReadingTransformation[R, Active]
```

where the types `ActiveReading` and `` `=>AR` `` are defined as follows

```scala
package pdbp.types.active.reading

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.types.active.activeTypes._

import pdbp.computation.transformation.reading.ReadingTransformation._

object activeReadingTypes {

  type ActiveReading[R] = ReadingTransformed[R, Active]

  type `=>AR`[R] = Kleisli[ActiveReading[R]]

}
```

Note that, since there is a type parameter `R` involved, we first define a `trait` and second a corresponding `implicit object` (for `BigInt`).

### **Describing `ReadingTransformedMeaning`**

The transformed computation meaning corresponding to the reading computation transformation `trait ReadingTransformation` is `trait ReadingTransformedMeaning`.

```scala
package pdbp.computation.meaning.reading

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.reading.ReadingTransformation
import pdbp.computation.transformation.reading.ReadingTransformation._

import pdbp.computation.meaning.ComputationMeaning

private[pdbp] trait ReadingTransformedMeaning[R, FC[+ _]: Computation, T[+ _]](
    implicit toBeTransformedMeaning: ComputationMeaning[FC, T])
    extends ComputationMeaning[ReadingTransformed[R, FC],
                               ReadingTransformed[R, T]] {

  private type RTFC = ReadingTransformed[R, FC]
  private type RTT = ReadingTransformed[R, T]

  override private[pdbp] val unaryTransformation: RTFC `~U~>` RTT =
    new {
      override private[pdbp] def apply[Z](rtfcz: RTFC[Z]): RTT[Z] =
        toBeTransformedMeaning.unaryTransformation(rtfcz(implicitly))

    }

}
```

### **Describing `activeIntReadingMeaningOfActiveIntReading`**

The next computation meaning `implicit object` (and corresponding kleisli program meaning `implicit object`) is the *active int reading meaning of active int reading* one defined below

```scala
package pdbp.program.meaning.ofActiveIntReading.activeIntReading

import pdbp.types.active.activeTypes._
import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.implicits.active.implicits.activeProgram

import pdbp.computation.meaning.ComputationMeaning

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.reading.ReadingTransformedMeaning

import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive

object implicits {

  import pdbp.program.implicits.active.reading.int.implicits.activeIntReadingProgram

  implicit object activeIntReadingMeaningOfActiveIntReading
      extends ReadingTransformedMeaning[BigInt, Active, Active]()
      with ComputationMeaning[ActiveReading[BigInt], ActiveReading[BigInt]]()
      with ProgramMeaning[`=>AR`[BigInt], `=>AR`[BigInt]]()
}
```

### **Running `mainFactorial` using `activeIntReadingProgram` and `activeIntReadingMeaningOfActiveIntReading`, and `read` and `effectfulWriteFactorialOfIntToConsole`**

Consider

```scala
package examples.main.active.reading.int.effectfulWriting

import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.implicits.active.reading.int.implicits.activeIntReadingProgram

import examples.mainPrograms.MainFactorial

object FactorialOfIntReadMain extends MainFactorial[`=>AR`[BigInt]]() {

  import examples.utils.EffectfulUtils

  private val effectfulUtils = new EffectfulUtils[`=>AR`[BigInt]]

  import effectfulUtils._

  override val producer = activeIntReadingProgram.read

  override val consumer = effectfulWriteFactorialOfIntReadToConsole

  def main(args: Array[String]): Unit = {

    import examples.utils.effects.implicits.readIntFromConsoleEffect

    import pdbp.program.meaning.ofActiveIntReading.activeIntReading.implicits.activeIntReadingMeaningOfActiveIntReading.meaning

    meaning(mainFactorial)(())

  }
}
```

where `readIntFromConsoleEffect` executes the effect that is described by `read`.

```scala
package pdbp.utils.effects

import pdbp.types.effect.console.consoleTypes._

import pdbp.utils.effectfulUtils._

object implicits {

  // ...

  private def readIntFromConsoleEffectWithMessage(message: String): BigInt =
    effectfulReadIntFromConsoleFunction(message)(())

  implicit val readIntFromConsoleEffect: BigInt =
    readIntFromConsoleEffectWithMessage("please type an integer to read")

  // ...

}
```

For being able to run `mainFactorial`, we have to define the `implicit BigInt` of `` read: Unit => (BigInt `I=>`BigInt) ``.
We can postpone defining this to the body of `main` and we can simply do this by `import`ing  `implicit val readIntFromConsoleEffect`.

Let's try running `factorial` with `10`.

```scala
[info] Running examples.main.active.reading.int.effectfulWriting.FactorialOfIntReadMain
please type an integer to read
10
the factorial value of the integer read is
3628800
```

Note that we use `read` as a producer *at the beginning* of a program.

### **Describing `FactorialMultipliedByIntRead`**

We can use `read` *anywhere* in a program.

Consider

```scala
package examples.programs.reading.int

import pdbp.program.Program
import pdbp.program.reading.Reading

import pdbp.program.compositionOperator._
import pdbp.program.constructionOperators._

import examples.programs.Factorial

class FactorialMultipliedByIntRead[
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Reading[BigInt, >-->]]
    extends Factorial[>-->] {

  private val implicitProgram = implicitly[Program[>-->]]

  import implicitProgram._

  private val implicitIntReading = implicitly[Reading[BigInt, >-->]]

  import implicitIntReading._

  val factorialMultipliedByIntRead: BigInt >--> BigInt =
    (factorial & read) >--> multiply

}
```

Note that
 - `factorial` has type `BigInt >--> BigInt`, 
 - `read[Int]` has type `BigInt >--> BigInt`, and therefore
 - `factorial & read` has type `BigInt >--> (BigInt && BigInt)`, and
 - `multiply` has type `(BigInt && BigInt) >--> BigInt`.

Also note that
 - the type inferencer can live with `read` instead of `read[Int]`,
 - `read` does not use it's argument at all (it ignores it using `z>-->u`).

#### **Describing `mainFactorialMultipliedByIntRead`**

Consider

```scala
package examples.mainPrograms.reading.int

import pdbp.program.Program
import pdbp.program.reading.Reading

import pdbp.program.compositionOperator._

import examples.programs.reading.int.FactorialMultipliedByIntRead

trait MainFactorialMultipliedByIntRead[
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Reading[BigInt, >-->]] {

  private object factorialMultipliedByIntReadObject
      extends FactorialMultipliedByIntRead[>-->]

  import factorialMultipliedByIntReadObject.factorialMultipliedByIntRead

  val producer: Unit >--> BigInt

  val consumer: BigInt >--> Unit

  lazy val mainFactorialMultipliedByIntRead: Unit >--> Unit =
    producer >-->
      factorialMultipliedByIntRead >-->
      consumer

}
```

`trait MainFactorialMultipliedByIntRead` defines `lazy val mainFactorialMultipliedByIntRead` using abstract members `producer` and `consumer`.

### **Running `mainFactorialMultipliedByIntRead` using `activeIntReadingProgram` and `activeIntReadingMeaningOfActiveIntReading`, and `effectfulReadIntFromConsole` and `effectfulWriteFactorialOfIntToConsole`**

Consider

```scala
package examples.main.active.reading.int.effectfulReadingAndWriting

import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.implicits.active.reading.int.implicits.activeIntReadingProgram

import examples.mainPrograms.reading.int.MainFactorialMultipliedByIntRead

object FactorialMultipliedByIntReadMain
    extends MainFactorialMultipliedByIntRead[`=>AR`[BigInt]]() {

  import examples.utils.EffectfulUtils

  private val effectfulUtils = new EffectfulUtils[`=>AR`[BigInt]]

  import effectfulUtils._

  override val producer = effectfulReadIntFromConsole

  override val consumer =
    effectfulWriteFactorialOfIntMultipliedByIntReadToConsole

  def main(args: Array[String]): Unit = {

    import examples.utils.effects.implicits.readIntFromConsoleEffect

    import pdbp.program.meaning.ofActiveIntReading.activeIntReading.implicits.activeIntReadingMeaningOfActiveIntReading.meaning

    meaning(mainFactorialMultipliedByIntRead)(())

  }
  
}
```

where

```scala
trait EffectfulUtils[>-->[- _, + _]: Function] {

  // ...

  val effectfulWriteFactorialOfIntMultipliedByIntReadToConsole
    : BigInt >--> Unit =
    effectfulWriteLineToConsoleWithMessage(
      "the factorial value of the integer multiplied by the integer read is")

}
```

Let's try running `factorialMultipliedByIntRead` with `10` and let's `read` 2 as multiplication factor.

```scala
[info] Running examples.main.active.reading.int.effectfulReadingAndWriting.FactorialMultipliedByIntReadMain
please type an integer
10
please type an integer to read
2
the factorial value of the integer multiplied by the integer read is
7257600
```

## **Describing `Writing`**

### **Introduction**

In sections `Program` and `Computation` we presented the basic programming and computation capabilities. 

In this section we introduce the next extra programming capability: *writing*. 

We already used a effectful input reading using producers of type `Unit >--> Z` that are used together with a effectful output writing using consumers of type `Y >--> Unit` to turn programs of type `Z >--> Y` into main programs of type `Unit >--> Unit`. 

In this section we describe effectfree output writing of type W >--> Unit and, more generally, effectfree writing of type Z >--> Unit.

Think, for example, of the effectfree writing capability of this section as being able to 

  - write *logging*

### **Describing `Writing`**

Consider

```scala
package pdbp.program.writing

import pdbp.types.implicitFunctionType._

import pdbp.types.product.productType._

import pdbp.writable.Writable

import pdbp.program.Function

import pdbp.program.Composition

import pdbp.program.Construction

trait Writing[W: Writable, >-->[- _, + _]] {
  this: Function[>-->] & Composition[>-->] & Construction[>-->] =>

  private[pdbp] val `w>-->u`: W >--> Unit = write(identity)

  private[pdbp] def `z>-w->u`[Z]: (Z => W) `I=>` Z >--> Unit =
    compose(function(implicitly), `w>-->u`)

  def write[Z]: (Z => W) `I=>` Z >--> Unit =
    `z>-w->u`

  def writingUsing[Z, Y, X](
      `(z&&y)=>x`: ((Z && Y) => X)): (Z >--> Y) => ((X => W) `I=>` Z >--> Y) = {
    `z>-->y` =>
      val `(z&&y)>-->x` = function(`(z&&y)=>x`)
      val `z>-->(x&&y)` =
        `let` {
          `z>-->y`
        } `in` {
          `let` {
            `(z&&y)>-->x`
          } `in` {
            `(z&&y&&x)>-->(x&&y)`
          }
        }
      compose(compose(`z>-->(x&&y)`, left(`z>-w->u`)), `(u&&y)>-->y`)
  }

}
```

`Writable` is described later in this section.

Think of `` `w>-->u` `` as a program that *writes* a *writable* value of type `W`.

Think of `` `z>-w->u` `` as a program that *writes* a value of type `Z` that can `implicitly` be converted (using a function of type `Z => W`) to a `Writable` of type `W`.

Note that `` `w>-->u` `` and `` `z>-w->u` `` are `private[pdbp]`. 
Since we are defining a public programming API, it is also convenient to define a `public` alias `write` for `` `z>-w->u` ``.

Moreover we define a `public` capability `writeUsing`. 

Think of ` `writeUsing(`(z&&y)=>x`)(`z>-->y`) `` as the program `z>-->y` that also writes a value of type `X` that is yielded by transforming `z>-->y`'s argument of type `Z` and `z>-->y`'s result of type `Y` to a result of type `X`.

### **Describing `Writable`**

Consider

```scala
package pdbp.writable

import pdbp.types.const.constType._

import pdbp.utils.functionUtils._

import pdbp.computation.Lifting

trait Writable[W]
    extends Startable[W]
    with Appendable[W]
    with Lifting[Const[W]] {

  override private[pdbp] def liftFunction[Z, Y](`z=>y`: Z => Y): W => W = `w=>w`

}
```

where

```scala
package pdbp.writable

import pdbp.types.const.constType._

import pdbp.computation.ObjectLifting

private[pdbp] trait Startable[W] extends ObjectLifting[Const[W]] {

  private[pdbp] val start: W

  override private[pdbp] def liftObject[Z](z: Z): W = start

}
```

and

```scala
package pdbp.writable

import pdbp.types.product.productType._

import pdbp.types.const.constType._

import pdbp.utils.productUtils._

import pdbp.computation.OperatorLifting

private[pdbp] trait Appendable[W] extends OperatorLifting[Const[W]] {

  private[pdbp] val append: W && W => W

  override private[pdbp] def liftOperator[Z, Y, X](
      `(z&&y)=>x`: (Z && Y) => X): (W && W) => W = append

}
```

The relationship with `Lifting` is defined in terms of the type `Const` below

```scala
package pdbp.types.const

object constType {

  type Const[X] = [+Z] => X

}
```

`trait Writable` corresponds to *monoids*.

## **Describing `WritingTransformation`**

The next computation transformer that we describe is `trait WritingTransformer` that is used to add the writing capability to program descriptions.

```scala
package pdbp.computation.transformation.writing

import pdbp.types.implicitFunctionType._

import pdbp.types.product.productType._

private[pdbp] object WritingTransformation {

  private[pdbp] type WritingTransformed[W, FC[+ _]] = [+Z] => FC[W && Z]

}

import WritingTransformation._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.writable.Writable

import pdbp.program.Program
import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait WritingTransformation[W: Writable, FC[+ _]: Computation]
    extends ComputationTransformation[FC, WritingTransformed[W, FC]]
    with Writing[W, Kleisli[WritingTransformed[W, FC]]] {

  private type WTFC = WritingTransformed[W, FC]
  private type `=>WTFC` = Kleisli[WTFC]

  private val implicitComputation = implicitly[Computation[FC]]

  import implicitComputation.{bind => bindFC}
  import implicitComputation.{result => resultFC}

  private val implicitWritable = implicitly[Writable[W]]

  import implicitWritable._

  override private[pdbp] val transform: FC `~U~>` WTFC = new {
    override private[pdbp] def apply[Z](fcz: FC[Z]): WTFC[Z] =
      bindFC(fcz, { z =>
        resultFC((start, z))
      })
  }

  override private[pdbp] def result[Z]: Z => WTFC[Z] = { z =>
    resultFC((start, z))
  }

  override private[pdbp] def bind[Z, Y](
      wtfcz: WTFC[Z],
      `z=>wtfcy`: => (Z => WTFC[Y])): WTFC[Y] =
    bindFC(wtfcz, { (leftW, z) =>
      bindFC(`z=>wtfcy`(z), { (rightW, y) =>
        resultFC(append(leftW, rightW), y)
      })
    })

  private[pdbp] override val `w>-->u`: W `=>WTFC` Unit = { w =>
    resultFC((w, ()))
  }

}
```

where

```scala
import pdbp.types.product.productType._

private[pdbp] object WritingTransformation { 

  type WritingTransformed[W, FC[+ _]] = [+Z] => FC[W && Z]

}
```

### **Describing `activeWritingToConsoleProgram`**

The next implicit computation object (and corresponding implicit kleisli program object) is the *active writing to console* one defined below

```scala
package pdbp.program.implicits.active.writing.toConsole

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.activeTypes._
import pdbp.types.active.writing.activeWritingTypes._

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import pdbp.program.Program

import pdbp.program.writing.Writing

import pdbp.program.implicits.active.writing.ActiveWritingProgram
import pdbp.program.implicits.active.implicits.activeProgram

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.writing.WritingTransformation

object implicits {

  implicit object activeWritingToConsoleProgram
      extends ActiveWritingProgram[ToConsole]()
      with Computation[ActiveWriting[ToConsole]]()
      with Program[`=>AW`[ToConsole]]()
      with Writing[ToConsole, `=>AW`[ToConsole]]()
      with ComputationTransformation[Active, ActiveWriting[ToConsole]]()
      with WritingTransformation[ToConsole, Active]()

}
```

where

```scala
package pdbp.program.implicits.active.writing

import pdbp.types.active.activeTypes._
import pdbp.types.active.writing.activeWritingTypes._

import pdbp.writable.Writable

import pdbp.program.Program
import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.writing.WritingTransformation

private[pdbp] trait ActiveWritingProgram[W: Writable]
    extends Computation[ActiveWriting[W]]
    with Program[`=>AW`[W]]
    with Writing[W, `=>AW`[W]]
    with ComputationTransformation[Active, ActiveWriting[W]]
    with WritingTransformation[W, Active]
```

where the types `ActiveWriting` and `` `=>AW` `` are defined as follows

```scala
package pdbp.types.active.writing

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.types.active.activeTypes._

import pdbp.computation.transformation.writing.WritingTransformation._

object activeWritingTypes {

  type ActiveWriting[W] = WritingTransformed[W, Active]

  type `=>AW`[W] = Kleisli[ActiveWriting[W]]

}
```

Note that, since there is a type parameter `W` involved, we first define a `trait` and second a corresponding `implicit object` for `ToConsole`, defined below.

```scala
package pdbp.types.effect.toConsole

import pdbp.types.effect.effectType._

case class ToConsole(effect: Effect)
```

where

```scala
package pdbp.types.effect

object effectType {

  type Effect = Unit => Unit

}
```

Note that we still have to show that `ToConsole` satisfies the `Writable` requirements

### **Describing `toConsoleWritable`**

```scala
package pdbp.writable.implicits.toConsole

import pdbp.types.product.productType._

import pdbp.types.effect.toConsole.ToConsole

import pdbp.writable.Writable

object implicits {

  implicit object toConsoleWritable extends Writable[ToConsole] {

    override private[pdbp] val start: ToConsole =
      ToConsole { _ =>
        ()
      }

    override private[pdbp] val append: ToConsole && ToConsole => ToConsole = {
      (tc1, tc2) =>
        ToConsole { _ =>
          { tc1.effect(()); tc2.effect(()) }
        }
    }

  }

}

```

## **Describing `activeIntReadingWithWritingToConsoleProgram`**

The next implicit computation object (and corresponding implicit kleisli program object) is the *active reading int with writing to console* one defined below

```scala
package pdbp.program.implicits.active.reading.int.writing.toConsole

import pdbp.types.active.activeTypes._
import pdbp.types.active.writing.activeWritingTypes._
import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._
import pdbp.types.effect.toConsole.ToConsole

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.program.implicits.active.reading.writing.ActiveReadingWithWritingProgram

import pdbp.program.implicits.active.writing.toConsole.implicits.activeWritingToConsoleProgram

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

import pdbp.computation.transformation.reading.writing.ReadingWithWritingTransformation

object implicits {

  implicit object activeIntReadingWithWritingToConsoleProgram
      extends ActiveReadingWithWritingProgram[BigInt, ToConsole]()
      with Computation[ActiveReadingWithWriting[BigInt, ToConsole]]()
      with Program[`=>ARW`[BigInt, ToConsole]]()
      with Reading[BigInt, `=>ARW`[BigInt, ToConsole]]()
      with Writing[ToConsole, `=>ARW`[BigInt, ToConsole]]()
      with ReadingWithWritingTransformation[BigInt,
                                            ToConsole,
                                            ActiveWriting[ToConsole]]()
      with ReadingTransformation[BigInt, ActiveWriting[ToConsole]]()
      with ComputationTransformation[
        ActiveWriting[ToConsole],
        ActiveReadingWithWriting[BigInt, ToConsole]]()

}
```

where

```scala
package pdbp.program.implicits.active.reading.writing

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import pdbp.writable.Writable

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation

import pdbp.computation.transformation.reading.writing.ReadingWithWritingTransformation

private[pdbp] trait ActiveReadingWithWritingProgram[R, W: Writable]
    extends Computation[ActiveReadingWithWriting[R, W]]
    with Program[`=>ARW`[R, W]]
    with Reading[R, `=>ARW`[R, W]]
    with Writing[W, `=>ARW`[R, W]]
    with ComputationTransformation[ActiveWriting[W],
                                   ActiveReadingWithWriting[R, W]]
    with ReadingWithWritingTransformation[R, W, ActiveWriting[W]]
```

where

```scala
package pdbp.computation.transformation.reading.writing

import pdbp.types.implicitFunctionType._

import pdbp.types.product.productType._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.writable.Writable

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.computation.transformation.reading.ReadingTransformation
import pdbp.computation.transformation.reading.ReadingTransformation._

private[pdbp] trait ReadingWithWritingTransformation[
    R, W: Writable, 
    FC[+ _]: Computation
           : [FC[+ _]] => Writing[W, Kleisli[FC]]]
    extends ReadingTransformation[R, FC]
    with Writing[W, Kleisli[ReadingTransformed[R, FC]]] {

  private val implicitWriting: Writing[W, Kleisli[FC]] =
    implicitly[Writing[W, Kleisli[FC]]]

  private type RTFC = ReadingTransformed[R, FC]

  private type `=>RTFC` = Kleisli[RTFC]

  override private[pdbp] val `w>-->u`: W `=>RTFC` Unit = { w =>
    implicitWriting.`w>-->u`(w)
  }

}
```

where the types `ActiveReadingWithWriting` and `` `=>ARW` `` are defined as follows

```scala
package pdbp.types.active.reading.writing

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.computation.transformation.reading.ReadingTransformation._

object activeReadingWithWritingTypes {

  type ActiveReadingWithWriting[R, W] = ReadingTransformed[R, ActiveWriting[W]]

  type `=>ARW`[R, W] = Kleisli[ActiveReadingWithWriting[R, W]]

}
```

### **Describing `WritingToConsoleTransformedMeaning`**

The transformed computation meaning corresponding to the writing computation transformation `trait WritingTransformation` is, when writing to the console, `trait WritingToConsoleTransformedMeaning`.

```scala
package examples.mainPrograms.reading.int.writing.toConsole

package pdbp.computation.meaning.writing.toConsole

import pdbp.types.effect.toConsole.ToConsole

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.writing.WritingTransformation
import pdbp.computation.transformation.writing.WritingTransformation._

import pdbp.computation.meaning.ComputationMeaning

private[pdbp] trait WritingToConsoleTransformedMeaning[FC[+ _]: Computation,
T[+ _]](implicit toBeTransformedMeaning: ComputationMeaning[FC, T])
    extends ComputationMeaning[WritingTransformed[ToConsole, FC], T] {

  private val implicitComputation = implicitly[Computation[FC]]

  import implicitComputation._

  private type WTFC = WritingTransformed[ToConsole, FC]

  val effectfulUnaryTransformation: WTFC `~U~>` FC =
    new {
      override private[pdbp] def apply[Z](wtfcz: WTFC[Z]): FC[Z] =
        bind(wtfcz, {
          case (ToConsole(effect), z) =>
            effect(())
            result(z)
        })
    }

  override private[pdbp] val unaryTransformation: WTFC `~U~>` T =
    effectfulUnaryTransformation andThen toBeTransformedMeaning.unaryTransformation

}
```

Note that this writing meaning transfoemation is *specific* for `ToConsole`.

The natural unary type transformation `unaryTransformation` defining `meaning` can be defined as a composition of `effectfulUnaryTransformation` and `toBeTransformedMeaning.unaryTransformation`.

Note that `effectfulUnaryTransformation` executes the writing to the console effect. 

### **Describing `activeMeaningOfActiveWritingToConsole`**

The next computation meaning `implicit object` (and corresponding kleisli program meaning `implicit object`) is the active meaning of active writing to console one defined below

```scala
package pdbp.program.meaning.ofActiveWritingToConsole.active

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.activeTypes._
import pdbp.types.active.writing.activeWritingTypes._

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.writing.toConsole.WritingToConsoleTransformedMeaning

import pdbp.program.implicits.active.implicits.activeProgram
import pdbp.program.implicits.active.writing.toConsole.implicits.activeWritingToConsoleProgram

object implicits {

  import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive

  implicit object activeMeaningOfActiveWritingToConsole
      extends WritingToConsoleTransformedMeaning[Active, Active]()
      with ComputationMeaning[ActiveWriting[ToConsole], Active]()
      with ProgramMeaning[`=>AW`[ToConsole], `=>A`]()
}
```

### **Describing `activeIntReadingMeaningOfActiveIntReadingWithWritingToConsole`**

The next computation meaning `implicit object` (and corresponding kleisli program meaning `implicit object`) is the active reaading meaning of active reading with writing to console one defined below

```scala
package pdbp.program.meaning.ofActiveIntReadingWithWritingToConsole.activeIntReading

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.activeTypes._
import pdbp.types.active.reading.activeReadingTypes._
import pdbp.types.active.writing.activeWritingTypes._
import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.reading.ReadingTransformedMeaning

import pdbp.program.implicits.active.implicits.activeProgram
import pdbp.program.implicits.active.writing.toConsole.implicits.activeWritingToConsoleProgram
import pdbp.program.implicits.active.reading.int.writing.toConsole.implicits.activeIntReadingWithWritingToConsoleProgram

object implicits {

  import pdbp.program.meaning.ofActiveWritingToConsole.active.implicits.activeMeaningOfActiveWritingToConsole

  implicit object activeIntReadingMeaningOfActiveIntReadingWithWritingToConsole
      extends ReadingTransformedMeaning[BigInt,
                                        ActiveWriting[ToConsole],
                                        Active]()
      with ComputationMeaning[ActiveReadingWithWriting[BigInt, ToConsole],
                              ActiveReading[BigInt]]()
      with ProgramMeaning[`=>ARW`[BigInt, ToConsole], `=>AR`[BigInt]]()

}
```

### **Describing `WritingFactorial`**

Consider

```scala
package examples.programs.writing

import pdbp.types.implicitFunctionType._

import pdbp.types.product.productType._

import pdbp.program.Program

import pdbp.writable.Writable

import pdbp.program.writing.Writing

import pdbp.program.compositionOperator._

import examples.programs.HelperPrograms

import examples.programs.writing.utils.infoUtils._

class WritingFactorial[
    W: Writable,
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Writing[W, >-->]]
    extends WritingAtomicPrograms[W, >-->]() 
    with HelperPrograms[>-->]() {

  private val implicitProgram = implicitly[Program[>-->]]

  private val implicitWriting = implicitly[Writing[W, >-->]]

  import implicitProgram._

  import implicitWriting._

  val writingFactorial: (String => W) `I=>` BigInt >--> BigInt =
    info("factorial") {
      `if`(isZero) {
        one
      } `else` {
        `let` {
          subtractOne >-->
            writingFactorial
        } `in` {
          multiply
        }
      }
    }

}
```

where

```scala
package examples.programs.writing

import pdbp.types.implicitFunctionType._

import pdbp.types.product.productType._

import pdbp.program.Function

import pdbp.writable.Writable

import pdbp.program.writing.Writing

import examples.utils.functionUtils._

import examples.programs.HelperPrograms

import examples.programs.writing.utils.infoUtils

import examples.programs.writing.utils.infoUtils.{info => _, _}

trait WritingAtomicPrograms[
    W: Writable, 
    >-->[- _, + _]: Function
                  : [>-->[- _, + _]] => Writing[W, >-->]]
    extends HelperPrograms[>-->] {

  private val implicitFunction = implicitly[Function[>-->]]

  private val implicitWriting = implicitly[Writing[W, >-->]]

  import implicitFunction._

  import implicitWriting._

  def info[Z, Y](string: String): (Z >--> Y) => ((String => W) `I=>` Z >--> Y) =
    infoUtils.info(string)

  val isZero: (String => W) `I=>` BigInt >--> Boolean =
    info("isZero") {
      isZeroHelper
    }

  val subtractOne: (String => W) `I=>` BigInt >--> BigInt =
    info("subtractOne") {
      subtractOneHelper
    }

  val multiply: (String => W) `I=>` (BigInt && BigInt) >--> BigInt =
    info("multiply") {
      multiplyHelper
    }

  def one[Z]: (String => W) `I=>` Z >--> BigInt =
    info("one") {
      oneHelper
    }

}
```

where

```scala
package examples.programs.writing.utils

import java.util.Calendar
import java.text.SimpleDateFormat

import pdbp.types.implicitFunctionType._

import pdbp.types.product.productType._

import pdbp.writable.Writable

import pdbp.program.writing.Writing

object infoUtils {

  def currentCalendarInMilliseconds: String = {
    val calendar = Calendar.getInstance();
    val millisecondsSimpleDateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss.SSS")
    millisecondsSimpleDateFormat.format(calendar.getTime())
  }

  def currentThreadId: Long = Thread.currentThread.getId

  def infoFunction[Z, Y](string: String): Z && Y => String = {
    case (z, y) =>
      s"INFO -- $currentCalendarInMilliseconds -- $string($z) => $y"
  }

  def info[
      W: Writable, 
      Z, 
      Y, 
       >-->[- _, + _]: [>-->[- _, + _]] => Writing[W, >-->]]
      (string: String): (Z >--> Y) => ((String => W) `I=>` Z >--> Y) = {
    val implicitWriting = implicitly[Writing[W, >-->]]
    implicitWriting.writingUsing(infoFunction(string))
  }

}
```

### **Describing `mainWritingFactorial`**

Consider

```scala
package examples.mainPrograms.writing

import pdbp.types.implicitFunctionType._

import pdbp.writable.Writable

import pdbp.program.Program
import pdbp.program.writing.Writing

import pdbp.program.compositionOperator._

import examples.programs.writing.WritingFactorial

trait MainWritingFactorial[
    W: Writable,
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Writing[W, >-->]] {

  private object writingFactorialObject extends WritingFactorial[W, >-->]

  import writingFactorialObject.writingFactorial

  val producer: Unit >--> BigInt

  val consumer: BigInt >--> Unit

  lazy val mainWritingFactorial: (String => W) `I=>` Unit >--> Unit = {
    producer >-->
      writingFactorial >-->
      consumer
  }

}
```

`trait MainWritingFactorial` defines `lazy val mainWritingFactorial` using abstract members `producer` and `consumer`.

### **Running `mainWritingFactorial` using `activeIntReadingWithWritingToConsoleProgram` and `activeIntReadingMeaningOfActiveIntReadingWithWritingToConsole`, and `read` and `write`

Consider

```scala
package examples.main.active.reading.int.writing.toConsole

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import pdbp.program.implicits.active.reading.int.writing.toConsole.implicits.activeIntReadingWithWritingToConsoleProgram

import examples.mainPrograms.writing.MainWritingFactorial

object FactorialOfIntReadWritingToConsoleWrittenToConsoleMain
    extends MainWritingFactorial[ToConsole, `=>ARW`[BigInt, ToConsole]]() {

  import examples.utils.effects.implicits.readIntFromConsoleEffect

  import examples.utils.effects.implicits.writeFactorialOfIntToConsoleEffect

  import examples.utils.effects.implicits.writeToConsoleEffect

  override val producer = activeIntReadingWithWritingToConsoleProgram.read

  override val consumer = activeIntReadingWithWritingToConsoleProgram.write

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActiveIntReadingWithWritingToConsole.activeIntReading.implicits.activeIntReadingMeaningOfActiveIntReadingWithWritingToConsole.meaning

    meaning(mainWritingFactorial)(())

  }

}
```


### **Describing `MainFactorialOfIntReadWrittenToConsole` using `read` and `write`**

Consider



We replaced `effectfulWriteFactorialOfIntToConsole` that executes an effect by `write` that describes an effect.

### **Running `factorialMain` using `mainFactorialOfIntReadWrittenToConsole`, `read` and `write`**

Consider

```scala
package examples.objects.active.reading.int.writing.toConsole

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import pdbp.program.implicits.active.reading.int.writing.toConsole.implicits
import implicits.activeIntReadingWithWritingToConsoleProgram

import examples.mainPrograms.reading.int.writing.toConsole.MainFactorialOfIntReadWrittenToConsole

object mainFactorialOfIntReadWrittenToConsole
    extends MainFactorialOfIntReadWrittenToConsole[`=>ARW`[BigInt, ToConsole]]()
```

We can now, finally, define main in object `FactorialOfIntReadWrittenToConsoleMain`.

```scala
package examples.main.active.reading.int.writing.toConsole

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import examples.objects.active.reading.int.writing.toConsole.mainFactorialOfIntReadWrittenToConsole
import mainFactorialOfIntReadWrittenToConsole.factorialMain

import examples.main.Main

object FactorialOfIntReadWrittenToConsoleMain
    extends Main[`=>ARW`[BigInt, ToConsole]] {

  import examples.utils.effects.implicits.readIntFromConsoleEffect

  import examples.utils.effects.implicits.writeFactorialOfIntReadFromConsoleToConsoleEffect

  private type `=>ARW[BigInt, ToConsole]` = `=>ARW`[BigInt, ToConsole]

  override val mainKleisliProgram: Unit `=>ARW[BigInt, ToConsole]` Unit =
    factorialMain

  override val run = mainKleisliProgram(()) match {
    case (ToConsole(effect), _) => effect(())
  }

}
```

where `writeFactorialOfIntReadFromConsoleToConsoleEffect`  executes the effect that is described by `write`.

```scala
package pdbp.utils.effects

import pdbp.types.effect.toConsole.ToConsole

import pdbp.utils.effectfulUtils._

object implicits {

  // ...

  private def writeLineToConsoleEffectWithMessage[Z](
      message: String): Z => ToConsole = { z =>
    ToConsole({ _ =>
      effectfulWriteLineToConsoleFunction(message)(z)
    })
  }

  implicit val writeFactorialOfIntReadFromConsoleToConsoleEffect
    : BigInt => ToConsole =
    writeLineToConsoleEffectWithMessage(
      "the factorial value of the integer read is")

  // ...    

}
```

Let's try running `factorial` with `10`.

```scala
[info] Running examples.main.active.reading.int.writing.toConsole.FactorialOfIntReadWrittenToConsoleMain
please type an integer to read
10
the factorial value of the integer read is
3628800
```

We used `write` as an effectfree alternative for the effectful `effectfulWriteFactorialOfIntToConsole` at the end of a program.

We can also use `writeUsing` anywhere in a program.



### **Describing `MainFactorialOfIntReadWritingToConsoleWrittenToConsole` using `read` and `write`**

Consider

```scala
package examples.mainPrograms.reading.int.writing.toConsole

import pdbp.types.implicitFunctionType._

import pdbp.types.effect.toConsole.ToConsole

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.program.compositionOperator._

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import examples.programs.writing.WritingFactorial

class MainFactorialOfIntReadWritingToConsoleWrittenToConsole[
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Reading[BigInt, >-->]
                  : [>-->[- _, + _]] => Writing[ToConsole, >-->]] {

  private val implicitIntReading = implicitly[Reading[BigInt, >-->]]

  private val implicitToConsoleWriting = implicitly[Writing[ToConsole, >-->]]

  import implicitIntReading._

  import implicitToConsoleWriting._

  private object writingFactorialObject
      extends WritingFactorial[ToConsole, >-->]

  import writingFactorialObject.factorial

  val factorialMain
    : (String => ToConsole) `I=>` ((BigInt => ToConsole) `I=>` Unit >--> Unit) =
    read >-->
      factorial >-->
      write

}
```

### **Running factorialMain using `mainFactorialOfIntReadWritingToConsoleWrittenToConsole`, `read` and `write`**

Consider

```scala
package examples.objects.active.reading.int.writing.toConsole

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import pdbp.program.implicits.active.reading.int.writing.toConsole.implicits
import implicits.activeIntReadingWithWritingToConsoleProgram

import examples.mainPrograms.reading.int.writing.toConsole.MainFactorialOfIntReadWritingToConsoleWrittenToConsole

object mainFactorialOfIntReadWritingToConsoleWrittenToConsole
    extends MainFactorialOfIntReadWritingToConsoleWrittenToConsole[
      `=>ARW`[BigInt, ToConsole]]()
```

We can now, finally, define main in object `FactorialOfIntReadWritingToConsoleWrittenToConsoleMain`.

```scala
package examples.main.active.reading.int.writing.toConsole

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import examples.objects.active.reading.int.writing.toConsole.mainFactorialOfIntReadWritingToConsoleWrittenToConsole
import mainFactorialOfIntReadWritingToConsoleWrittenToConsole.factorialMain

import examples.main.Main

object FactorialOfIntReadWritingToConsoleWrittenToConsoleMain
    extends Main[`=>ARW`[BigInt, ToConsole]] {

  import examples.utils.effects.implicits.readIntFromConsoleEffect

  import examples.utils.effects.implicits.writeFactorialOfIntReadFromConsoleToConsoleEffect

  import examples.utils.effects.implicits.writeToConsoleEffect

  private type `=>ARW[BigInt, ToConsole]` = `=>ARW`[BigInt, ToConsole]

  override val mainKleisliProgram: Unit `=>ARW[BigInt, ToConsole]` Unit =
    factorialMain

  override val run = mainKleisliProgram(()) match {
    case (ToConsole(effect), _) => effect(())
  }

}
```

where `writeToConsoleEffect` executes the effect that is described by `write` as part of the definition of `writeUsing`.


```scala
object implicits {

  // ...

  private def writeToConsoleEffectWithMessage[Z](
      message: String): Z => ToConsole = { z =>
    ToConsole({ _ =>
      effectfulWriteToConsoleFunction(message)(z)
    })
  }

  implicit val writeToConsoleEffect: String => ToConsole =
    writeToConsoleEffectWithMessage("")

  // ...

}
```

Ok, so let’s use `main` in `object FactorialOfIntReadWritingToConsoleWrittenToConsoleMain`.

Let’s try 10.

```scala
[info] Running examples.main.active.reading.int.writing.toConsole.FactorialOfIntReadWritingToConsoleWrittenToConsoleMain
please type an integer to read
10
INFO
 --time 2018-08-01 10:53:14.909
 --thread 252
 --evaluating isZero(10) yields false
INFO
 --time 2018-08-01 10:53:14.918
 --thread 252
 --evaluating subtractOne(10) yields 9
INFO
 --time 2018-08-01 10:53:14.919
 --thread 252
 --evaluating isZero(9) yields false
INFO
 --time 2018-08-01 10:53:14.920
 --thread 252
 --evaluating subtractOne(9) yields 8
INFO
 --time 2018-08-01 10:53:14.920
 --thread 252
 --evaluating isZero(8) yields false
INFO
 --time 2018-08-01 10:53:14.921
 --thread 252
 --evaluating subtractOne(8) yields 7
INFO
 --time 2018-08-01 10:53:14.921
 --thread 252
 --evaluating isZero(7) yields false
INFO
 --time 2018-08-01 10:53:14.922
 --thread 252
 --evaluating subtractOne(7) yields 6
INFO
 --time 2018-08-01 10:53:14.923
 --thread 252
 --evaluating isZero(6) yields false
INFO
 --time 2018-08-01 10:53:14.923
 --thread 252
 --evaluating subtractOne(6) yields 5
INFO
 --time 2018-08-01 10:53:14.924
 --thread 252
 --evaluating isZero(5) yields false
INFO
 --time 2018-08-01 10:53:14.924
 --thread 252
 --evaluating subtractOne(5) yields 4
INFO
 --time 2018-08-01 10:53:14.925
 --thread 252
 --evaluating isZero(4) yields false
INFO
 --time 2018-08-01 10:53:14.925
 --thread 252
 --evaluating subtractOne(4) yields 3
INFO
 --time 2018-08-01 10:53:14.926
 --thread 252
 --evaluating isZero(3) yields false
INFO
 --time 2018-08-01 10:53:14.926
 --thread 252
 --evaluating subtractOne(3) yields 2
INFO
 --time 2018-08-01 10:53:14.927
 --thread 252
 --evaluating isZero(2) yields false
INFO
 --time 2018-08-01 10:53:14.927
 --thread 252
 --evaluating subtractOne(2) yields 1
INFO
 --time 2018-08-01 10:53:14.928
 --thread 252
 --evaluating isZero(1) yields false
INFO
 --time 2018-08-01 10:53:14.928
 --thread 252
 --evaluating subtractOne(1) yields 0
INFO
 --time 2018-08-01 10:53:14.929
 --thread 252
 --evaluating isZero(0) yields true
INFO
 --time 2018-08-01 10:53:14.930
 --thread 252
 --evaluating one(0) yields 1
INFO
 --time 2018-08-01 10:53:14.931
 --thread 252
 --evaluating factorial(0) yields 1
INFO
 --time 2018-08-01 10:53:14.931
 --thread 252
 --evaluating multiply((1,1)) yields 1
INFO
 --time 2018-08-01 10:53:14.931
 --thread 252
 --evaluating factorial(1) yields 1
INFO
 --time 2018-08-01 10:53:14.932
 --thread 252
 --evaluating multiply((2,1)) yields 2
INFO
 --time 2018-08-01 10:53:14.932
 --thread 252
 --evaluating factorial(2) yields 2
INFO
 --time 2018-08-01 10:53:14.933
 --thread 252
 --evaluating multiply((3,2)) yields 6
INFO
 --time 2018-08-01 10:53:14.933
 --thread 252
 --evaluating factorial(3) yields 6
INFO
 --time 2018-08-01 10:53:14.933
 --thread 252
 --evaluating multiply((4,6)) yields 24
INFO
 --time 2018-08-01 10:53:14.934
 --thread 252
 --evaluating factorial(4) yields 24
INFO
 --time 2018-08-01 10:53:14.934
 --thread 252
 --evaluating multiply((5,24)) yields 120
INFO
 --time 2018-08-01 10:53:14.934
 --thread 252
 --evaluating factorial(5) yields 120
INFO
 --time 2018-08-01 10:53:14.935
 --thread 252
 --evaluating multiply((6,120)) yields 720
INFO
 --time 2018-08-01 10:53:14.935
 --thread 252
 --evaluating factorial(6) yields 720
INFO
 --time 2018-08-01 10:53:14.935
 --thread 252
 --evaluating multiply((7,720)) yields 5040
INFO
 --time 2018-08-01 10:53:14.936
 --thread 252
 --evaluating factorial(7) yields 5040
INFO
 --time 2018-08-01 10:53:14.936
 --thread 252
 --evaluating multiply((8,5040)) yields 40320
INFO
 --time 2018-08-01 10:53:14.936
 --thread 252
 --evaluating factorial(8) yields 40320
INFO
 --time 2018-08-01 10:53:14.937
 --thread 252
 --evaluating multiply((9,40320)) yields 362880
INFO
 --time 2018-08-01 10:53:14.937
 --thread 252
 --evaluating factorial(9) yields 362880
INFO
 --time 2018-08-01 10:53:14.937
 --thread 252
 --evaluating multiply((10,362880)) yields 3628800
INFO
 --time 2018-08-01 10:53:14.937
 --thread 252
 --evaluating factorial(10) yields 3628800
the factorial value of the integer read is
3628800
```
