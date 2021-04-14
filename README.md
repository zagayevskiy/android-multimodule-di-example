# Пример построения межмодульного DI. [ Mobius 2021 Piter](https://mobius-piter.ru/).

### Основная идея
Основная идея состоит в разделении графа зависимостей на части &ndash; в каждом feature-модуле свой граф зависимостей, а также в поиске зависимостей по андроидовской иерархии предков(Fragment &ndash; Parent Fragment &ndash; ... &ndash; Parent Fragment &ndash; Activity &ndash; Application).
Подробнее можно посмотреть на [слайдах](https://github.com/zagayevskiy/android-multimodule-di-example/blob/master/YandexMapsDi.pdf) доклада.

Это не архитектурный шаблон! Пример показывает исключительно внедрение зависимостей, всё остальное сделано максимально упрощённо.


### Описание модулей

* [:app](https://github.com/zagayevskiy/android-multimodule-di-example/tree/master/app/src/main/java/com/example/multimoduleappexample) &ndash; основной модуль приложения. Использует все три фичи. Является примером того, как организовать предоставление зависимостей фиче-модулям с помощью Dagger 2, а так же как связать фичи друг с другом. 

* [:core](https://github.com/zagayevskiy/android-multimodule-di-example/tree/master/core/src/main/java/com/example/core), [:core-dagger](https://github.com/zagayevskiy/android-multimodule-di-example/tree/master/core-dagger/src/main/java/com/example/core/dagger) &ndash; утилитарные модули, нужные для обеспечения работы DI. Именно здесь находится весь "библиотечный" код.

* [:feature1](https://github.com/zagayevskiy/android-multimodule-di-example/tree/master/feature1/src/main/java/com/example/feature1) &ndash; пример простейшей UI-фичи, реализованной одним фрагментом. Пример того, как фиче-модуль получает зависимости.

* [:feature1:sample](https://github.com/zagayevskiy/android-multimodule-di-example/tree/master/feature1/feature1-sample/src/main/java/com/example/feature1_sample) &ndash; пример sample-app для фичи feature1. Также пример того, как можно организовать предоставление зависимостей без использования каких-либо DI-фреймворков.

* [:feature2](https://github.com/zagayevskiy/android-multimodule-di-example/tree/master/feature2/src/main/java/com/example/feature2) &ndash; пример UI-фичи, которой необходимо использовать другую UI-фичу. Идея в том, что нужно делегировать создание фрагмента и предоставление зависимостей для вложенной фичи app-модулю. В данном случае feature2 использует feature1, но не зависит от неё.
sample-app для feature2 не реализован, т.к. он не принёс бы дополнительной ценности в рамках данного примера. В реальном приложении для каждого фиче-модуля желательно иметь сэмпл.

* [:feature3-no-ui](https://github.com/zagayevskiy/android-multimodule-di-example/tree/master/feature3-no-ui/src/main/java/com/example/feature3_no_ui) &ndash; пример не-UI фичи, которую достаточно сложно сконструировать из-за наличия внутренних и внешних зависимостей. Идея в том, что необходимо в качестве реализации фабрики использовать Dagger2 Component.


### The MIT License (MIT)

Copyright (c) 2021 Denis Zagayevskiy

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
