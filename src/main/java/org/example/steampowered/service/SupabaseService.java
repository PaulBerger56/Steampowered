// package org.example.steampowered.service;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;
// import org.supabase.PostgrestClient;
// import org.supabase.SupabaseClient;
// import org.supabase.models.PostgrestResponse;
// import org.supabase.models.PostgrestUpsertResponse;

// import org.example.steampowered.Constants;

// @Service
// public class SupabaseService {

    
//     private String supabaseUrl = Constants.SUPABASE_URL;

    
//     private String supabaseApiKey = Constants.SUPABASE_ANON_KEY;

//     private final SupabaseClient supabaseClient;

//     public SupabaseService() {
//         this.supabaseClient = new SupabaseClient(supabaseUrl, supabaseApiKey);
//     }

//     public PostgrestResponse upsertUser(User user) {
//         PostgrestClient postgrestClient = supabaseClient.from("users");
//         PostgrestUpsertResponse<User> response = postgrestClient.upsert()
//                 .setBody(user)
//                 .execute();

//         return response;
//     }
// }

