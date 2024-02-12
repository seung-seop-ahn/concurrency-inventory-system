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

## Problem & Solution 2

- Race condition
  - The `synchronized` keyword is guaranteed only within one process. 
  - If there is only one server, this is fine, but if there are multiple servers, access to the data occurs from multiple places.
- Pessimistic Lock
  - If collisions occur frequently, better performance than Optimistic Lock.
  - Guarantee data consistency.
  - Performance may decrease.

## Author

👤 **Kevin Ahn**

* Github: [@seung-seop-ahn](https://github.com/seung-seop-ahn)