package com.jmc.androidutils.registry

private typealias ScreenModule = ScreenRegistry.() -> Unit

 fun screenModule(block: ScreenModule): ScreenModule =
    { block() }
