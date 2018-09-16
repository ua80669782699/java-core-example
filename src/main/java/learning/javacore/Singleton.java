package learning.javacore;

public class Singleton {
}
class Single{
    private Single(){}// не ленивый, тоесть создается всегда независомо воспользуемся ли мы им

    public static Single single = new Single();

    public static Single getSingle(){
        return  single;
    }
}

class SingleLazy{
    private SingleLazy(){}// ленивый, дабл чек обязательно + volatile( запрещаем реордеринг)

    public volatile static SingleLazy single;

    public static SingleLazy getSingleLazy(){
        if(single == null){
            synchronized (SingleLazy.class){
                if(single == null){
                    single = new SingleLazy();
                }
            }
        }
        return  single;
    }
}