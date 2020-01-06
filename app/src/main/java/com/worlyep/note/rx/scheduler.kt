package com.worlyep.note.rx

/**
 * # RxJava / RxAndroid 제공하는 스케쥴러
 *
 * @ Schedulers.computation()
 * - 이벤트 루프에서 간단한 연산이나 콜백 처리를 위해 사용
 * - RxComputationThreadPool라는 별도의 스레드 풀에서 돌아감
 * - 최대 CPU 갯수 개의 스레드 풀이 순환하면서 실행
 *
 * @ Schedulers.immediate()
 * - 현재 스레드에서 즉시 수행합니다.
 * - observeOn()이 여러번 쓰였을 경우
 *   immediate()를 선언한 바로 윗쪽의 스레드를 따라감
 *
 * @ Schedulers.from(executor)
 * - 특정 executor를 스케쥴러로 사용
 *
 * @ Schedulers.io()
 * - 동기 I/O를 별도로 처리시켜 비동기 효율을 얻기 위한 스케줄러
 * - 자체적인 스레드 풀 CachedThreadPool을 사용
 * - API 호출 등 네트워크를 사용한 호출 시 사용
 *
 * @ Schedulers.newThread()
 * - 새로운 스레드를 만드는 스케쥴러
 *
 * @ Schedulers.trampoline()
 * - 큐에 있는 일이 끝나면 이어서 현재 스레드에서 수행하는 스케쥴러
 *
 * @ AndroidSchedulers.mainThread()
 * - 안드로이드의 UI 스레드에서 동작
 *
 * @ HandlerScheduler.from(handler)
 * - 특정 핸들러 handler에 의존하여 동작
 *
 **/

/**
 * # CompositeDisposable class
 **/

/**
 * # FlatMap / SwitchMap / ConcatMap
 * [https://softwaree.tistory.com/30]
 **/

/**
 * [https://altongmon.tistory.com/758]
 **/

/**
 * RxJava를 이용한 다중 api 호출 관련 링크
 * [https://nittaku.tistory.com/179]
 **/

/**
 * Factory 함수
 * https://altongmon.tistory.com/750?category=836621
        **/