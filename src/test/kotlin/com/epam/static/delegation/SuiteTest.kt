package com.epam.static.delegation

import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(FileStorageTest::class, FileTest::class)
internal class SuiteTest