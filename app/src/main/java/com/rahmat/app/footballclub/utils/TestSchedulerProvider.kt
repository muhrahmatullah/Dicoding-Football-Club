package com.rahmat.app.footballclub.utils

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by muhrahmatullah on 05/09/18.
 */
class TestSchedulerProvider: SchedulerProvider {
    override fun ui(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun computation(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun newThread(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }
}