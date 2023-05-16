package trains;

@FunctionalInterface
interface IFunc<T, E> {

    E action(T t);
}

