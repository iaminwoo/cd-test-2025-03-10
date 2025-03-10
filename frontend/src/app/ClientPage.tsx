"use client";

import { useEffect, useState } from "react";

type PostDto = {
  id: number;
  title: string;
  content: string;
};

export default function ClientPage() {
  const [posts, setPosts] = useState<PostDto[]>([]);

  useEffect(() => {
    const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL;
    fetch(`${API_BASE_URL}/api/posts`)
      .then((res) => res.json())
      .then((data: PostDto[]) => setPosts(data))
      .catch((error) => console.error("Failed to fetch posts:", error));
  }, []);

  return (
    <div className="max-w-2xl mx-auto bg-white shadow-md rounded-lg p-6 mt-5">
      <h1 className="text-2xl font-bold mb-4 text-gray-800">📜 글 목록</h1>
      <ul className="divide-y divide-gray-200">
        {posts.map((post) => (
          <li
            key={post.id}
            className="p-4 border-b last:border-b-0 hover:bg-gray-100 transition"
          >
            <strong className="text-xl font-semibold text-gray-900">
              - 제목 : {post.title}
            </strong>
            <p className="text-gray-600">- 내용 : {post.content}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}
