package learning.javacore;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Reference {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();//стронг - пока в стеке есть ссылка на обьект, тоестьв методе

        WeakReference<Object> weakReference = new WeakReference<>(o);//Weak при первом же проходе GC удалит обьект о, удобно для кешей локальных.
        SoftReference<Object> softReference = new SoftReference<>(o);//Soft аналог предидущему но GC удалит лишь тогда когда когда память юудет заканчиватся, тоесть может пережить несколько GC сборок

        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o, referenceQueue);// для того чтоб убедится что GC убрал етот обьект
        referenceQueue.remove();// это в другом потоке, зависнит пока не пройдет GC
        System.gc();

        WeakHashMap weakHashMap = new WeakHashMap(); // так как у нас вне мапы не осталось стронг ссылок на "jjj" то при перевом проходе GC мапа посистится
        weakHashMap.put("jjj", new Object());
    }
}
