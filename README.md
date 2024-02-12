# Welcome to concurrency-stock-system 👋
![Version](https://img.shields.io/badge/version-0.0.0-blue.svg?cacheSeconds=2592000)

> Concurrency Stock System

## Install

```sh
$ docker-compose up -d
```

## Problem & Solution 1

- Race condition (stock update)
- `synchronized`
  - `@Transactional` can also cause race condition. So must remove before using it.

## Author

👤 **Kevin Ahn**

* Github: [@seung-seop-ahn](https://github.com/seung-seop-ahn)