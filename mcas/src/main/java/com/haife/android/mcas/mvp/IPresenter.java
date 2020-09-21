package com.haife.android.mcas.mvp;/*
 * Copyright 2017 Haife
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * ================================================
 * 框架要求框架中的每个 Presenter 都需要实现此类,以满足规范
 *
 * @see BasePresenter
 * ================================================
 */
public interface IPresenter {

    /**
     * 做一些初始化操作
     */
    void onStart();

    /**
     * 在框架中  时会默认调用 {@link IPresenter#onDestroy()}
     */
    void onDestroy();
}
