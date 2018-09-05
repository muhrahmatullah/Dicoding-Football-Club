package com.rahmat.app.footballclub.utils

import io.reactivex.Scheduler

/**
 * Created by muhrahmatullah on 05/09/18.
 */
interface SchedulerProvider {
        fun ui(): Scheduler
        fun computation(): Scheduler
        fun trampoline(): Scheduler
        fun newThread(): Scheduler
        fun io(): Scheduler
}