package com.example.javaspring.thread.completable;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.random.RandomGenerator;
import lombok.Getter;

public class Ex2 {

    private static Map<UserInfo, Integer> rankMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                return getUserInfo(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenApply(UserInfo::getName);

        System.out.println("future.get() = " + future.get());

        CompletableFuture<UserRank> userRankCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return getUserInfo(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenCompose(u -> {
            try {
                return getUserRank(u);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("userRankCompletableFuture = " + userRankCompletableFuture.get());

        CompletableFuture<CompletableFuture<UserRank>> completableFutureCompletableFuture = CompletableFuture.supplyAsync(
            () -> {
                try {
                    return getUserInfo(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).thenApply(u -> {
            try {
                return getUserRank(u);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(
            "completableFutureCompletableFuture.get().get() = " + completableFutureCompletableFuture.get().get());

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 1)
            .thenApply(x -> x + 1);
        //CompletableFuture.supplyAsync(()->1).thenCompose(x->x+1); -> 컴파일 오류

    }

    public static UserInfo getUserInfo(int number) throws InterruptedException {
        Thread.sleep(2000);
        return new UserInfo("USER12");
    }

    public static CompletableFuture<UserRank> getUserRank(UserInfo userInfo) throws InterruptedException {
        Thread.sleep(2000);
        return CompletableFuture.supplyAsync(() -> new UserRank(1));
    }


    static class UserRank {
        int rank;

        public UserRank(int rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "UserRank{" +
                "rank=" + rank +
                '}';
        }
    }

    @Getter
    static class UserInfo {
        private String name;
        private int id;

        public UserInfo(String name) {
            this.name = name;
            this.id = RandomGenerator.getDefault().nextInt();
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
        }
    }
}
