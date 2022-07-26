# java8
* 함수형 인터페이스 (추상메서드가 한개인 인터페이스)
  * 자바8 인터페이스 내부에 스태틱 디폴트 등 다른형태에 메서드를 정의 할 수 있다.
  * @FunctionalInterface 어노테이션을 통해 함수형 인터페이스를 정의할 수 있다.
~~~
// 자바 8 이전 익명 내부 클래스
    RunSomething runSomething = new RunSomething() {
        @Override
        public void doIt() {
            System.out.println("hello");
        }
    };
// java8 람다를 사용해 간결해진 함수형 인터페이스
    RunSomething runSomething1 = () -> System.out.println("hello");
~~~