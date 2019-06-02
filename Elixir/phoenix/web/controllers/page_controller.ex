defmodule Hello.PageController do
  use Hello.Web, :controller
  alias Hello.World
  alias Hello.Fortune

  def index(conn, _params) do
    conn
    |> put_resp_content_type("application/json", nil)
    |> send_resp(200, Jason.encode_to_iodata!(%{"TE Benchmarks\n" => "Started"}))
  end

  # avoid namespace collision
  def _json(conn, _params) do
    conn
    |> put_resp_content_type("application/json", nil)
    |> send_resp(200, Jason.encode_to_iodata!(%{"message" => "Hello, world!"}))
  end

  def plaintext(conn, _params) do
    conn
    |> put_resp_content_type("text/plain", nil)
    |> send_resp(200, "Hello, world!")
  end
end
