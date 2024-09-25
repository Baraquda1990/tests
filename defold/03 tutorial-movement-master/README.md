# Movement tutorial

This is a tutorial for beginners. It walks you through the steps of creating a player controlled space ship that moves in a natural manner when you give keyboard input. After having completed this tutorial you will know the answers to the following questions:

* What are vectors?
* How can you use vectors to represent positions, velocity and acceleration?
* How do you use this to create a game embryo that you can experiment with and develop further?

It is assumed that you have basic understanding of physics concepts such as velocity and acceleration. You will also need some basic understanding of Lua programming.

This project is prepared in advance for you so there is no setup to bother about. [Run the game](defold://build) to get an overview of what you have to work with:

- It include graphics: an animated spaceship and a background.
- Input is set up for arrow keys and mouse clicks.
- There is a "spaceship" game object that has a script attached to it.
- The script has code in place to react to player input. Initially, it only prints messages to the console as a reaction to input.

With the game running, try pressing the arrow buttons, or click in the game window, then check the editor console for input results. Notice that different text is printed in the console depending on which button you pressed:

<img src="doc/input.png" srcset="doc/input@2x.png 2x">

## Making the spaceship move

Before digging into any details, let's first make a simple experiment and give the spaceship motion.

Open ["spaceship.script"](defold://open?path=/main/spaceship.script) and scroll down to the beginning of the function `on_input()` where you find this code:

```lua
function on_input(self, action_id, action)
    if action_id == hash("up") then
        print("UP!")
    elseif...
```

Remove the line with the statement `print("UP!")` and edit the code so the beginning of the function instead looks like this:

```lua
function on_input(self, action_id, action)
    if action_id == hash("up") then
        local p = go.get_position()
        p.y = p.y + 1
        go.set_position(p)
    elseif...
```

[Run the game](defold://build) again and press the <kbd>up</kbd> arrow key and see how the spaceship moves up. The code is very simple, but let's look at it line by line to get a proper idea of what's going on:

```lua
if action_id == hash("up") then
```

The input bindings that are set up in the project (in the file ["/input/game.input_binding"](defold://open?path=/input/game.input_binding)) binds each of the arrow keys to action named "up", "down", "left" and "right". The game runs at 60 frames per second and each frame you push <kbd>up</kbd>, the [hashed](https://en.wikipedia.org/wiki/Hash_function) "up" action name is sent to the `on_input()` function. Holding the button down will thus make the code between the `if` statement and the first `elseif` execute 60 times each second.

```lua
local p = go.get_position()
```

The function `go.get_position()` gets the position of a game object. Since the function is called without any arguments, the position of the *current* game object is returned. This code belongs to the spaceship game object so the position of the spaceship is returned.

The position is assigned to a local variable called `p` so it is possible to manipulate it. The position object is a `vector3`, which is a *vector* that holds three values.

```lua
p.y = p.y + 1
```

The `vector3` object in `p` describes a point in 3D space, consisting of an X coordinate, an Y coordinate and a Z coordinate. Since pressing the <kbd>up</kbd> button should move the ship in the positive direction of the Y axis, the `y` component of the position is increased by 1.

```lua
go.set_position(p)
```

Finally, the new changed position value is written back to the current game object.

Before moving on, try changing the value added to `p.y` from 1 to 5 and [run the game again](defold://build). Notice how the ship now moves much faster.

Finally, add a line below `go.set_position(p)` to print the value of `p`:

```lua
function on_input(self, action_id, action)
    if action_id == hash("up") then
        local p = go.get_position()
        p.y = p.y + 5
        go.set_position(p)
        print(p)
    elseif...
```

[Run the game again](defold://build) and see how the engine print the value of the position vector each frame. Notice that the second value of the vector changes as the spaceship moves:

```text
...
DEBUG:SCRIPT: vmath.vector3(640, 460, 0)
DEBUG:SCRIPT: vmath.vector3(640, 465, 0)
DEBUG:SCRIPT: vmath.vector3(640, 470, 0)
DEBUG:SCRIPT: vmath.vector3(640, 475, 0)
...
```

## Vectors

A vector is a mathematical entity that has a _direction_ and a _magnitude_ (length). A vector describes a specific point in a vector space. In practice, a vector consists of a set of numbers that give the coordinates to the point. In a two dimensional space (a plane), two numbers are necessary to describe vectors: one value for the X axis and one for the Y axis:

<img src="doc/2d-vector.png" srcset="doc/2d-vector@2x.png 2x">

In a three dimensional space, you need three numbers: one for the X axis, one for the Y axis and one for the Z axis:

<img src="doc/3d-vector.png" srcset="doc/3d-vector@2x.png 2x">

The magnitude, or length, of a vector *v* is calculated using the Pythagorean theorum:

<img src="doc/magnitude.png" srcset="doc/magnitude@2x.png 2x">

A vector with magnitude 1 is called a *normalized vector*.

Even though Defold has a toolset tailored for 2D games, the engine is truly a 3D engine. All game objects and components are positioned in 3D space with positions expressed as `vector3` objects. When you view your game in 2D, the X and Y value determine the position of an object along the "width" and "height" axis, and the Z position determines the position along the "depth" axis. The Z position allows you to control the visibility of overlapping objects: a sprite with a Z value of 1 will appear in front of a sprite at Z position 0. By default, Defold uses a coordinate system allowing Z values between -1 and 1:

<img src="doc/z-order.png" srcset="doc/z-order@2x.png 2x">

The Defold Lua library [`vmath`](https://defold.com/ref/vmath) contains functions to create and manipulate [`vector3`](https://defold.com/ref/vmath/#vmath.vector3) objects:

```lua
-- create a new vector3 at X position 100 and Y position 350.
local position = vmath.vector3(100, 350, 0)

-- set the position of game object "player" to the new vector.
go.set_position(position, "player")
```

Vectors in higher dimensions than 3 are also possible. Defold uses `vector4` objects with four components to encode colors. The first three components give the amount of red, green, and blue, and the last component give the amount of translucency, also called "alpha".

In everyday life you are used to do arithmetic with scalar values, real numbers that describe points on the number line. We use scalars to mean many different things. The number 12 could mean a number of meters, kilograms, pounds, seconds, meters per second, volts or dollars. The same is true for vectors. You have already seen how vectors can be used to describe a position of an object. They are also very good for describing an object's motion through space.

To describe motion on a computer screen (a 2D plane) you need two values: The speed along the X axis and the speed along the Y axis. You can very well use two separate scalar values and add the speed values to the X and Y positions separately:

```lua
position_x = position_x + speed_x * elapsed_seconds
position_y = position_y + speed_y * elapsed_seconds
```

This is roughly what you did when you previously made the spaceship move upwards, and there is nothing wrong calculating motion like this. Vectors, however, allow you to express motion clearer and more concise. Since a vector describe a *direction* and a *magnitude* they are an intuitive fit for motion: the direction of the vector equals the direction of motion, and the magnitude describes the amount of motion:

```lua
position = position + speed * elapsed_seconds
```

As long as the `position` and `speed` values are expressed as vectors in the same space you can add and subtract them, and scale them by multiplying them with scalar values. These operations are a central part of *vector algebra*.

## Vector algebra

Vector algebra defines mathematical operations on vectors. Beginning with the simplest, negation, addition and subtraction.

Negation
: Negating a vector *v*, denoted by -*v*, negates each component of the vector. This makes a vector that points in the opposite direction of the original vector, with the same magnitude:

  <img src="doc/vector-neg.png" srcset="doc/vector-neg@2x.png 2x">

Addition
: Adding vector *u* to vector *v*, denoted by *u* + *v*, adds each component of *u* to *v*. The result is a new vector:

  <img src="doc/vector-add-cs.png" srcset="doc/vector-add-cs@2x.png 2x">

  Vectors are often drawn displaced from the coordinate system which brings clarity to the operations:

  <img src="doc/vector-add.png" srcset="doc/vector-add@2x.png 2x">

Subtraction
: Subtracting vector *v* from vector *u*, denoted by *u* - *v*, is equal to adding the negation of *v* to *u*. So *u* - *v* = *u* + (-*v*):

  <img src="doc/vector-sub.png" srcset="doc/vector-sub@2x.png 2x">

Multiplication with scalar
: Multiplying a vector *v* with a real number *r* produces a new vector with the magnitude scaled: the vector is streched out by a factor *r*. Multiplying with a negative *r* flips the orientation 180 degrees:
  
  <img src="doc/vector-mul.png" srcset="doc/vector-mul@2x.png 2x">

These were the basic operations on vectors that you will use all the time. In addition, there are two special operations that come in handy if you, for instance, want to check if two vectors are parallel or at right angles of each other:

Dot product
: The dot product of two vectors *u* and *v*, denoted by *u ∙ v*, is a scalar value. It is defined as:

  <img src="doc/dot.png" srcset="doc/dot@2x.png 2x">

  - *‖u‖* is the magnitude of vector *u*.
  - *‖v‖* is the magnitude of vector *v*.
  - *θ* is the angle between the vectors.

  <img src="doc/vector-dot.png" srcset="doc/vector-dot@2x.png 2x">

  If the vectors are orthogonal (the angle between them is 90 degrees), then the dot product is zero.

Cross product
: The cross product of two vectors *u* and *v*, denoted by *u* × *v*, is a vector that is perpendicular to both *u* and *v*:

  <img src="doc/vector-cross.png" srcset="doc/vector-cross@2x.png 2x">

  The resulting vector is a zero vector if:

  - Either one or both of the input vectors are zero vectors, (*u* = 0 or *v* = 0)
  - The two input vectors are parallel (θ = 0°)
  - The two input vectors are antiparallel (θ = 180°)

## Creating movement with vectors

Using vector algebra, you can now rewrite the spaceship's movement in a straightforward way.

Open ["spaceship.script"](defold://open?path=/main/spaceship.script) and modify the `init()`, `update()` and `on_input()` functions:

```lua
function init(self)
    msg.post(".", "acquire_input_focus")
    self.input = vmath.vector3()                -- [1]
end
```
1. Create a new zero `vector3` for storing the input direction. It is placed it in the current script instance (`self`) so it can be used throughout the lifetime of the spaceship game object.

```lua
function update(self, dt)
    local movement = self.input * 3             -- [1]
    local p = go.get_position()                 -- [2]
    go.set_position(p + movement)               -- [3]
    self.input = vmath.vector3()                -- [4]
end
```
1. Calculate a movement vector based on the player's input vector.
2. Retrieve the position of the current game object (the spaceship). The position is a `vector3`.
2. Set the position of the current game object to `p` plus the movement vector.
3. Zero the input vector. The `on_input()` function is called each frame before `update()` and has the responsibility to set the input vector.

```lua
function on_input(self, action_id, action)
    if action_id == hash("up") then
        self.input.y = 1                     -- [1]
    elseif action_id == hash("down") then
        self.input.y = -1                    -- [1]
    elseif action_id == hash("left") then
        self.input.x = -1                    -- [1]
    elseif action_id == hash("right") then
        self.input.x = 1                     -- [1]
    elseif action_id == hash("click") and action.pressed then
        print("CLICK!")
    end
end
```
1. Set the x or y component of the input vector depending on player input. If the player presses `up` and `left` at the same time, the function will be called twice and both components are set, resulting in a diagonal input direction.

There are two issues with this code:

First, the input vector has length 1 if you move vertically or horizontally, but diagonally the length is 1.4142 (square root of 2) so diagonal movement is faster. You probably don't want that.

Second, the units of velocity is expressed in pixels/frame, no matter the frame length. It's set to 3 pixels of movement each frame (or about 4.2 diagonally). To make the ship go faster, change the 3 to a higher value. If you want it to go slower, decrease the value. It would be better if you could express velocity in pixels/second.

The first problem is easy to fix, just normalize the input vector so the input length is always 1:

```lua
function update(self, dt)
    if vmath.length_sqr(self.input) > 1 then        -- [1]
        self.input = vmath.normalize(self.input)
    end
    local movement = self.input * 3
    local p = go.get_position()
    go.set_position(p + movement)
    self.input = vmath.vector3()
end
```
1. If the squared length of the input vector is larger than 1, normalize the vector so it is of magnitude 1. Compare against square length since it's faster than comparing against length.

The second problem requires the use of a time step value.

## Time step

Each frame the Defold engine calls the `update()` function of each script. A Defold game usually runs at 60 frames per second, so each frame is 0.016666 seconds long. That is the time elapsed between each call to `update()`. A velocity vector with a magnitude of 3 will then represent a speed of 3 * 60 = 180 pixels per second (with the regular render script), *as long as there really are 60 frames each second*. What would happen if there, for whatever reason, is a hitch in the framerate? With the current code movement will be uneven and unpredictable.

Working with pixels per second allows you to use variable framerate properly, you would also be able to measure your game with a stopwatch and reason about distances and timings in a better way.

Defold provides a time step argument value to the `update()` function. The argument is usually called `dt` (for "delta time") and its value is the number of *seconds* that elapsed since the last frame. If you scale velocity against `dt` you will get proper units:

```lua
function update(self, dt)
    if vmath.length_sqr(self.input) > 1 then
        self.input = vmath.normalize(self.input)
    end
    local movement = self.input * 150 * dt              -- [1]  
    local p = go.get_position()
    go.set_position(p + movement)
    self.input = vmath.vector3()
end
```
1. The velocity is now 150 pixels per second. The screen is 1280 pixels wide so it should take the ship 8.53 seconds to fly across. You can check that with a stopwatch.

[Run the game again](defold://build) and try the movement code. At this stage it works but it's stiff and not very dynamic. To give a sense of weight to the spaceship a good way is to have the player's input control movement by altering acceleration instead of the velocity.

## Acceleration

In the above code, velocity was set to a constant value, meaning that the resulting movement, or translation, of the velocity acting over the time step (`dt`) could be calculated by multiplying the velocity with the time step: *movement* = *velocity* * *dt*, or the orange area in the following diagram:

<img src="doc/integration-constant.png" srcset="doc/integration-constant@2x.png 2x">

Acceleration defines how fast something changes speed and direction. The acceleration is acting over the frame time step (`dt`) and then added to the velocity. The velocity acts over the frame and the resulting movement is added to the position. Since velocity changes over time the movement has to be calculated as the area under a curve. In mathematics, this is called [integration over time](http://en.wikipedia.org/wiki/Integral).

<img src="doc/integration.png" srcset="doc/integration@2x.png 2x">

With a small enough time step a good geometric approximation of the area can be calculated by assuming that the acceleration acting between *v0* and *v1* is constant, meaning that the velocity changes linearly between the two points. By that assumption *v1* can be calculated as *v0* + *acceleration* * *dt* and the resulting movement becomes:

<img src="doc/movement.png" srcset="doc/movement@2x.png 2x">

You can now write the final code for `init()` and `update()` (the code for `on_input()` is kept as is):

```lua
function init(self)
    msg.post(".", "acquire_input_focus")
    self.velocity = vmath.vector3()             -- [1]
    self.input = vmath.vector3()
end

function update(self, dt)
    if vmath.length_sqr(self.input) > 1 then
        self.input = vmath.normalize(self.input)
    end
    
    local acceleration = self.input * 200       -- [2]
    
    local dv = acceleration * dt                -- [3]
    local v0 = self.velocity                    -- [4]
    local v1 = self.velocity + dv               -- [5]
    local movement = (v0 + v1) * dt * 0.5       -- [6]

    local p = go.get_position()
    go.set_position(p + movement)               -- [7]

    self.velocity = v1                          -- [8]
    self.input = vmath.vector3()
end
```
1. Create a vector for storing velocity over time.
2. Acceleration is set to 200 pixels per second in the direction of player input.
3. Calculate change of velocity this time step.
4. v0 is set to the velocity from the previous time step.
5. v1 is v0 plus the change of velocity this time step.
6. Calculate how much the ship shall move this time step.
7. Apply the change in position.
8. Store the v1 velocity so it can be used in next time step.

Now it's time to [take your new heavy spaceship for a spin](defold://build).

Congratulations! You have completed the tutorial. But don't stop here. to continue experimenting with the code.

Here are some ideas what you can try:

1. Put a cap on the velocity.
2. Make the spaceship bounce off the edges of the screen.
3. Allow mouse clicks to dictate the input direction.

Check out [the documentation pages](https://defold.com/learn) for more examples, tutorials, manuals and API docs.

If you run into trouble, help is available in [our forum](https://forum.defold.com).

Happy Defolding!

----

This project is released under the Creative Commons CC0 1.0 Universal license.

You’re free to use these assets in any project, personal or commercial. There’s no need to ask permission before using these. Giving attribution is not required, but is greatly appreciated!
[Full license text](https://creativecommons.org/publicdomain/zero/1.0)

# Учебник по движению

Это учебник для начинающих. Он проведет вас через этапы создания космического корабля, управляемого игроком, который движется естественным образом, когда вы вводите данные с клавиатуры. После завершения этого учебника вы узнаете ответы на следующие вопросы:

* Что такое векторы?
* Как можно использовать векторы для представления положений, скорости и ускорения?
* Как использовать это для создания игрового эмбриона, с которым можно экспериментировать и развивать дальше?

Предполагается, что у вас есть базовые знания о физических концепциях, таких как скорость и ускорение. Вам также понадобятся некоторые базовые знания программирования Lua.

Этот проект подготовлен заранее, поэтому вам не нужно беспокоиться о настройке. [Запустите игру](defold://build), чтобы получить обзор того, с чем вам предстоит работать:

- Она включает графику: анимированный космический корабль и фон.
- Ввод настроен для клавиш со стрелками и щелчков мыши.
- Существует игровой объект «космический корабль», к которому прикреплен скрипт.
- Скрипт содержит код для реагирования на ввод игрока. Изначально он выводит сообщения на консоль только в качестве реакции на ввод.

Во время игры попробуйте нажать кнопки со стрелками или щелкнуть в окне игры, затем проверьте консоль редактора на наличие результатов ввода. Обратите внимание, что в консоли печатается разный текст в зависимости от того, какую кнопку вы нажали:

<img src="doc/input.png" srcset="doc/input@2x.png 2x">

## Заставляем космический корабль двигаться

Прежде чем углубляться в детали, давайте сначала проведем простой эксперимент и придадим космическому кораблю движение.

Откройте ["spaceship.script"](defold://open?path=/main/spaceship.script) и прокрутите вниз до начала функции `on_input()`, где вы найдете этот код:

```lua
function on_input(self, action_id, action)
if action_id == hash("up") then
print("UP!")
elseif...
```

Удалите строку с оператором `print("UP!")` и отредактируйте код так, чтобы начало функции выглядело так:

```lua
function on_input(self, action_id, action)
if action_id == hash("up") then
local p = go.get_position()
p.y = p.y + 1
go.set_position(p)
elseif...
```

[Запустите игру](defold://build) еще раз и нажмите клавишу со стрелкой <kbd>вверх</kbd>, чтобы увидеть, как космический корабль движется вверх. Код очень простой, но давайте рассмотрим его построчно, чтобы получить правильное представление о том, что происходит:

```lua
if action_id == hash("up") then
```

Привязки ввода, настроенные в проекте (в файле ["/input/game.input_binding"](defold://open?path=/input/game.input_binding)) связывают каждую из клавиш со стрелками с действием под названием "вверх", "вниз", "влево" и "вправо". Игра работает со скоростью 60 кадров в секунду, и в каждом кадре, когда вы нажимаете <kbd>вверх</kbd>, [хэшированное](https://en.wikipedia.org/wiki/Hash_function) имя действия "вверх" отправляется в функцию `on_input()`. Таким образом, удерживание кнопки заставит код между оператором `if` и первым `elseif` выполняться 60 раз в секунду.

```lua
local p = go.get_position()
```

Функция `go.get_position()` получает позицию игрового объекта. Поскольку функция вызывается без аргументов, возвращается позиция *текущего* игрового объекта. Этот код принадлежит игровому объекту космического корабля, поэтому возвращается позиция космического корабля.

Позиция присваивается локальной переменной с именем `p`, поэтому ею можно манипулировать. Объект позиции — это `vector3`, который является *вектором*, содержащим три значения.

```lua
p.y = p.y + 1
```

Объект `vector3` в `p` описывает точку в трехмерном пространстве, состоящую из координаты X, координаты Y и координаты Z. Так как нажатие кнопки <kbd>вверх</kbd> должно переместить корабль в положительном направлении оси Y, компонент `y` позиции увеличивается на 1.

```lua
go.set_position(p)
```

Наконец, новое измененное значение позиции записывается обратно в текущий игровой объект.

Прежде чем двигаться дальше, попробуйте изменить значение, добавленное к `p.y`, с 1 на 5 и [снова запустить игру](defold://build). Обратите внимание, что корабль теперь движется намного быстрее.

Наконец, добавьте строку ниже `go.set_position(p)`, чтобы вывести значение `p`:

```lua
function on_input(self, action_id, action)
if action_id == hash("up") then
local p = go.get_position()
p.y = p.y + 5
go.set_position(p)
print(p)
elseif...
```

[Запустите игру снова](defold://build) и посмотрите, как движок выводит значение вектора положения в каждом кадре. Обратите внимание, что второе значение вектора меняется по мере движения космического корабля:

```текст
...
DEBUG:SCRIPT: vmath.vector3(640, 460, 0)
DEBUG:SCRIPT: vmath.vector3(640, 465, 0)
DEBUG:SCRIPT: vmath.vector3(640, 470, 0)
DEBUG:SCRIPT: vmath.vector3(640, 475, 0)
...
```

## Векторы

Вектор — это математическая сущность, имеющая _направление_ и _величину_ (длину). Вектор описывает определенную точку в векторном пространстве. На практике вектор состоит из набора чисел, которые задают координаты точки. В двумерном пространстве (плоскости) для описания векторов необходимы два числа: одно значение для оси X и одно для оси Y:

<img src="doc/2d-vector.png" srcset="doc/2d-vector@2x.png 2x">

В трехмерном пространстве вам нужны три числа: одно для оси X, одно для оси Y и одно для оси Z:

<img src="doc/3d-vector.png" srcset="doc/3d-vector@2x.png 2x">

Величина или длина вектора *v* вычисляется с помощью теоремы Пифагора:

<img src="doc/magnitude.png" srcset="doc/magnitude@2x.png 2x">

Вектор с величиной 1 называется *нормализованным вектором*.

Несмотря на то, что Defold имеет набор инструментов, предназначенный для 2D-игр, движок на самом деле является 3D-движком. Все игровые объекты и компоненты размещаются в 3D-пространстве с позициями, выраженными как объекты `vector3`. Когда вы просматриваете свою игру в 2D, значения X и Y определяют положение объекта по осям "ширина" и "высота", а положение Z определяет положение по оси "глубина". Положение Z позволяет вам контролировать видимость перекрывающихся объектов: спрайт со значением Z 1 появится перед спрайтом в положении Z 0. По умолчанию Defold использует систему координат, допускающую значения Z от -1 до 1:

<img src="doc/z-order.png" srcset="doc/z-order@2x.png 2x">

Библиотека Defold Lua [`vmath`](https://defold.com/ref/vmath) содержит функции для создания и управления объектами [`vector3`](https://defold.com/ref/vmath/#vmath.vector3):

```lua
-- создать новый vector3 в положении X 100 и положении Y 350.
local position = vmath.vector3(100, 350, 0)

-- установить положение игрового объекта "player" на новый вектор.
go.set_position(позиция, "игрок")
```

Векторы в более высоких измерениях, чем 3, также возможны. Defold использует объекты `vector4` с четырьмя компонентами для кодирования цветов. Первые три компонента дают количество красного, зеленого и синего, а последний компонент дает количество прозрачности, также называемое «альфа».

В повседневной жизни вы привыкли выполнять арифметические действия со скалярными значениями, действительными числами, которые описывают точки на числовой прямой. Мы используем скаляры для обозначения множества разных вещей. Число 12 может означать количество метров, килограммов, фунтов, секунд, метров в секунду, вольт или долларов. То же самое верно и для векторов. Вы уже видели, как векторы можно использовать для описания положения объекта. Они также очень хороши для описания движения объекта в пространстве.

Чтобы описать движение на экране компьютера (двумерной плоскости), вам нужны два значения: скорость по оси X и скорость по оси Y. Вы можете вполне использовать два отдельных скалярных значения и добавлять значения скорости к позициям X и Y по отдельности:

```lua
position_x = position_x + speed_x * elapsed_seconds
position_y = position_y + speed_y * elapsed_seconds
```

Это примерно то, что вы делали, когда ранее заставляли космический корабль двигаться вверх, и нет ничего плохого в таком расчете движения. Векторы, однако, позволяют вам выражать движение более четко и кратко. Поскольку вектор описывает *направление* и *величину*, они интуитивно подходят для движения: направление вектора равно направлению движения, а величина описывает количество движения:

```lua
position = position + speed * elapsed_seconds
```

Пока значения `position` и `speed` выражены как векторы в одном и том же пространстве, вы можете складывать и вычитать их, а также масштабировать, умножая их на скалярные значения. Эти операции являются центральной частью *векторной алгебры*.

## Векторная алгебра

Векторная алгебра определяет математические операции над векторами. Начиная с самых простых: отрицание, сложение и вычитание.

Отрицание
: отрицание вектора *v*, обозначаемого как -*v*, отрицает каждый компонент вектора. Это создает вектор, который указывает в противоположном направлении исходного вектора, с той же величиной:

<img src="doc/vector-neg.png" srcset="doc/vector-neg@2x.png 2x">

Сложение
: добавление вектора *u* к вектору *v*, обозначаемому как *u* + *v*, добавляет каждый компонент *u* к *v*. Результатом является новый вектор:

<img src="doc/vector-add-cs.png" srcset="doc/vector-add-cs@2x.png 2x">

Векторы часто рисуются смещенными относительно системы координат, что вносит ясность в операции:

<img src="doc/vector-add.png" srcset="doc/vector-add@2x.png 2x">

Вычитание
: Вычитание вектора *v* из вектора *u*, обозначаемое *u* - *v*, равно добавлению отрицания *v* к *u*. Таким образом, *u* - *v* = *u* + (-*v*):

<img src="doc/vector-sub.png" srcset="doc/vector-sub@2x.png 2x">

Умножение со скаляром
: Умножение вектора *v* на действительное число *r* дает новый вектор с масштабированной величиной: вектор растягивается на коэффициент *r*. Умножение на отрицательное *r* переворачивает ориентацию на 180 градусов:

<img src="doc/vector-mul.png" srcset="doc/vector-mul@2x.png 2x">

Это были основные операции над векторами, которые вы будете использовать все время. Кроме того, есть две специальные операции, которые пригодятся, если вы, например, хотите проверить, параллельны ли два вектора или находятся ли они под прямым углом друг к другу:

Скалярное произведение
: Скалярное произведение двух векторов *u* и *v*, обозначаемое *u ∙ v*, является скалярной величиной. Оно определяется как:

<img src="doc/dot.png" srcset="doc/dot@2x.png 2x">

- *‖u‖* — это величина вектора *u*.
- *‖v‖* — это величина вектора *v*.
- *θ* — это угол между векторами.

<img src="doc/vector-dot.png" srcset="doc/vector-dot@2x.png 2x">

Если векторы ортогональны (угол между ними равен 90 градусов), то скалярное произведение равно нулю.

Перекрестное произведение
: Перекрестное произведение двух векторов *u* и *v*, обозначаемое *u* × *v*, является вектором, перпендикулярным как *u*, так и *v*:

<img src="doc/vector-cross.png" srcset="doc/vector-cross@2x.png 2x">

Результирующий вектор является нулевым вектором, если:

- Один или оба входных вектора являются нулевыми векторами, (*u* = 0 или *v* = 0)
- Два входных вектора параллельны (θ = 0°)
- Два входных вектора антипараллельны (θ = 180°)

## Создание движения с помощью векторов

Используя векторную алгебру, вы теперь можете переписать движение космического корабля простым способом.

Откройте ["spaceship.script"](defold://open?path=/main/spaceship.script) и измените функции `init()`, `update()` и `on_input()`:

```lua
function init(self)
msg.post(".", "acquire_input_focus")
self.input = vmath.vector3() -- [1]
end
```

1. Создайте новый нулевой `vector3` для хранения направления ввода. Он помещается в текущий экземпляр скрипта (`self`), чтобы его можно было использовать на протяжении всего жизненного цикла игрового объекта космического корабля.

```lua
function update(self, dt)
local movement = self.input * 3 -- [1]
local p = go.get_position() -- [2]
go.set_position(p + movement) -- [3]
self.input = vmath.vector3() -- [4]
end
```
1. Вычислите вектор движения на основе входного вектора игрока.
2. Получите позицию текущего игрового объекта (космического корабля). Позиция — это `vector3`.
2. Установите позицию текущего игрового объекта на `p` плюс вектор движения.
3. Обнулите входной вектор. Функция `on_input()` вызывается в каждом кадре перед `update()` и отвечает за установку входного вектора.

```lua
function on_input(self, action_id, action)
if action_id == hash("up") then
self.input.y = 1 -- [1]
elseif action_id == hash("down") then
self.input.y = -1 -- [1]
elseif action_id == hash("left") then
self.input.x = -1 -- [1]
elseif action_id == hash("right") then
self.input.x = 1 -- [1]
elseif action_id == hash("click") and action.pressed then
print("CLICK!")
end
end
```
1. Установите компонент x или y входного вектора в зависимости от ввода игрока. Если игрок одновременно нажмет `up` и `left`, функция будет вызвана дважды, и оба компонента будут установлены, что приведет к диагональному направлению ввода.

В этом коде есть две проблемы:

Во-первых, входной вектор имеет длину 1, если вы перемещаетесь по вертикали или горизонтали, но по диагонали длина составляет 1,4142 (квадратный корень из 2), поэтому диагональное движение происходит быстрее. Вероятно, вам это не нужно.

Во-вторых, единицы скорости выражаются в пикселях/кадр, независимо от длины кадра. Он установлен на 3 пикселя движения на каждый кадр (или около 4,2 по диагонали). Чтобы корабль двигался быстрее, измените 3 на большее значение. Если вы хотите, чтобы он двигался медленнее, уменьшите значение. Было бы лучше, если бы вы могли выразить скорость в пикселях/секунду.

Первую проблему легко исправить, просто нормализуйте входной вектор так, чтобы длина входных данных всегда была 1:

```lua
function update(self, dt)
if vmath.length_sqr(self.input) > 1 then -- [1]
self.input = vmath.normalize(self.input)
end
local movement = self.input * 3
local p = go.get_position()
go.set_position(p + movement)
self.input = vmath.vector3()
end
```
1. Если квадрат длины входного вектора больше 1, нормализуйте вектор так, чтобы он имел величину 1. Сравните с квадратом длины, так как это быстрее, чем сравнение с длиной.

Вторая проблема требует использования значения временного шага.

## Временной шаг

В каждом кадре движок Defold вызывает функцию `update()` каждого скрипта. Игра Defold обычно работает со скоростью 60 кадров в секунду, поэтому каждый кадр длится 0,016666 секунды. Это время, прошедшее между каждым вызовом `update()`. Вектор скорости с величиной 3 будет тогда представлять скорость 3 * 60 = 180 пикселей в секунду (с обычным скриптом рендеринга), *при условии, что в секунду действительно будет 60 кадров*. Что произойдет, если по какой-либо причине возникнет заминка в частоте кадров? С текущим кодом движение будет неравномерным и непредсказуемым.

Работа с пикселями в секунду позволяет вам правильно использовать переменную частоту кадров, вы также сможете измерять свою игру с помощью секундомера и лучше рассуждать о расстояниях и таймингах.

Defold предоставляет значение аргумента временного шага для функции `update()`. Аргумент обычно называется `dt` (для "дельта времени"), а его значение - это количество *секунд*, прошедших с последнего кадра. Если вы масштабируете скорость относительно `dt`, вы получите правильные единицы:

```lua
function update(self, dt)
if vmath.length_sqr(self.input) > 1 then
self.input = vmath.normalize(self.input)
end
local movement = self.input * 150 * dt -- [1]
local p = go.get_position()
go.set_position(p + movement)
self.input = vmath.vector3()
end
```

1. Скорость теперь составляет 150 пикселей в секунду. Ширина экрана составляет 1280 пикселей, поэтому кораблю потребуется 8,53 секунды, чтобы пересечь его. Вы можете проверить это с помощью секундомера.

[Запустите игру снова](defold://build) и попробуйте код движения. На этом этапе он работает, но он жесткий и не очень динамичный. Чтобы придать космическому кораблю ощущение веса, хороший способ — сделать так, чтобы ввод игрока управлял движением, изменяя ускорение вместо скорости.

## Ускорение

В приведенном выше коде скорость была установлена ​​на постоянное значение, что означает, что результирующее движение или перемещение скорости, действующей на шаге времени (`dt`), можно вычислить, умножив скорость на шаг времени: *движение* = *скорость* * *dt*, или оранжевая область на следующей диаграмме:

<img src="doc/integration-constant.png" srcset="doc/integration-constant@2x.png 2x">

Ускорение определяет, насколько быстро что-то меняет скорость и направление. Ускорение действует на шаге времени кадра (`dt`), а затем добавляется к скорости. Скорость действует на кадре, а результирующее движение добавляется к положению. Поскольку скорость изменяется со временем, движение должно быть рассчитано как площадь под кривой. В математике это называется [интегрированием по времени](http://en.wikipedia.org/wiki/Integral).

<img src="doc/integration.png" srcset="doc/integration@2x.png 2x">

При достаточно малом временном шаге можно рассчитать хорошую геометрическую аппроксимацию площади, предположив, что ускорение, действующее между *v0* и *v1*, является постоянным, что означает, что скорость изменяется линейно между двумя точками. При таком предположении *v1* можно вычислить как *v0* + *ускорение* * *dt*, и результирующее движение станет:

<img src="doc/movement.png" srcset="doc/movement@2x.png 2x">

Теперь вы можете написать окончательный код для `init()` и `update()` (код для `on_input()` сохраняется как есть):

```lua
function init(self)
msg.post(".", "acquire_input_focus")
self.velocity = vmath.vector3() -- [1]
self.input = vmath.vector3()
end

function update(self, dt)
if vmath.length_sqr(self.input) > 1 then
self.input = vmath.normalize(self.input)
end

local acceleration = self.input * 200 -- [2]

local dv = ускорение * dt -- [3]
local v0 = self.velocity -- [4]
local v1 = self.velocity + dv -- [5]
local movement = (v0 + v1) * dt * 0,5 -- [6]

local p = go.get_position()
go.set_position(p + movement) -- [7]

self.velocity = v1 -- [8]
self.input = vmath.vector3()
end
```
1. Создайте вектор для хранения скорости с течением времени.
2. Ускорение установлено на 200 пикселей в секунду в направлении ввода игрока.
3. Рассчитайте изменение скорости на этом временном шаге.
4. v0 установлено на скорость с предыдущего временного шага.
5. v1 равно v0 плюс изменение скорости на этом временном шаге.
6. Рассчитайте, насколько корабль должен переместиться на этом временном шаге.
7. Примените изменение положения.
8. Сохраните скорость v1, чтобы ее можно было использовать на следующем шаге времени.

Теперь пришло время [прокатить ваш новый тяжелый космический корабль](defold://build).

Поздравляем! Вы завершили урок. Но не останавливайтесь здесь. чтобы продолжить экспериментировать с кодом.

Вот несколько идей, которые вы можете попробовать:

1. Установите ограничение на скорость.
2. Заставьте космический корабль отскакивать от краев экрана.
3. Разрешите щелчкам мыши определять направление ввода.

Ознакомьтесь с [страницами документации](https://defold.com/learn) для получения дополнительных примеров, учебных пособий, руководств и документации API.

Если у вас возникнут проблемы, помощь доступна на [нашем форуме](https://forum.defold.com).

Счастливого распаковки!

----

Этот проект выпущен под лицензией Creative Commons CC0 1.0 Universal.

Вы можете свободно использовать эти ресурсы в любом проекте, личном или коммерческом. Нет необходимости спрашивать разрешение перед их использованием. Указание авторства не обязательно, но очень приветствуется!

[Полный текст лицензии](https://creativecommons.org/publicdomain/zero/1.0)